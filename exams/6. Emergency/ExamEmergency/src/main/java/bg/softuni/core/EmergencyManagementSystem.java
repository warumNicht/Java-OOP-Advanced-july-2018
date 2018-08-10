package bg.softuni.core;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.enums.EmergencyStatus;
import bg.softuni.interfaces.Center;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.Manager;
import bg.softuni.models.centers.FiremanCenter;
import bg.softuni.models.centers.MedicalCenter;
import bg.softuni.models.centers.PoliceCenter;
import bg.softuni.models.emergencies.HealthEmergency;
import bg.softuni.models.emergencies.OrderEmergency;
import bg.softuni.models.emergencies.PropertyEmergency;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class EmergencyManagementSystem implements Manager {
    private Map<String, List<Emergency>> emergencies;
    private Map<String, List<Center>> centers;

    private int fireCentersCount;
    private int medicalCentersCount;
    private int orderCentersCount;
    private int totalProcessedEmergencies;
    private long propertyDamageFixed;
    private long healthCasualtiesSaved;
    private int specialCasesProcessed;


    public EmergencyManagementSystem() {
        this.emergencies = new HashMap();
        this.emergencies.put("Property",new ArrayList<>());
        this.emergencies.put("Health",new ArrayList<>());
        this.emergencies.put("Order",new ArrayList<>());

        this.centers = new HashMap();
        this.centers.put("Property",new ArrayList<>());
        this.centers.put("Health",new ArrayList<>());
        this.centers.put("Order",new ArrayList<>());
    }

    @Override
    public String registerPropertyEmergency(String[] tokens) {
        String description = tokens[1];
        EmergencyLevel level = EmergencyLevel.valueOf(tokens[2]);
        String time = tokens[3];
        int damage = Integer.parseInt(tokens[4]);

        Emergency propertyEmerg = new PropertyEmergency(description, level, time, damage);
        this.emergencies.get("Property").add(propertyEmerg);

        return String.format("Registered Public Property Emergency of level %s at %s.",
                level.name(), time);
    }

    @Override
    public String registerHealthEmergency(String[] tokens) {
        String description = tokens[1];
        EmergencyLevel level = EmergencyLevel.valueOf(tokens[2]);
        String time = tokens[3];
        int damage = Integer.parseInt(tokens[4]);

        Emergency healthEmerg = new HealthEmergency(description, level, time, damage);
        this.emergencies.get("Health").add(healthEmerg);

        return String.format("Registered Public Health Emergency of level %s at %s.",
                level.name(), time);
    }

    @Override
    public String registerOrderEmergency(String[] tokens) {
        String description = tokens[1];
        String statuString = tokens[4].replace('-', '_');
        EmergencyLevel level = EmergencyLevel.valueOf(tokens[2]);
        String time = tokens[3];
        EmergencyStatus status = EmergencyStatus.valueOf(statuString);

        Emergency orderEmerg = new OrderEmergency(description, level, time, status);
        this.emergencies.get("Order").add(orderEmerg);

        return String.format("Registered Public Order Emergency of level %s at %s.",
                level.name(), time);
    }

    @Override
    public String registerFireServiceCenter(String[] tokens) {
        String name = tokens[1];
        int capacity = Integer.parseInt(tokens[2]);
        Center fireCenter = new FiremanCenter(name, capacity);
        this.centers.get("Property").add(fireCenter);

        return String.format("Registered Fire Service Emergency Center - %s.", name);
    }

    @Override
    public String registerMedicalServiceCenter(String[] tokens) {
        String name = tokens[1];
        int capacity = Integer.parseInt(tokens[2]);
        Center fireCenter = new MedicalCenter(name, capacity);
        this.centers.get("Health").add(fireCenter);

        return String.format("Registered Medical Service Emergency Center - %s.", name);
    }

    @Override
    public String registerPoliceServiceCenter(String[] tokens) {
        String name = tokens[1];
        int capacity = Integer.parseInt(tokens[2]);
        Center fireCenter = new PoliceCenter(name, capacity);
        this.centers.get("Order").add(fireCenter);

        return String.format("Registered Police Service Emergency Center - %s.", name);
    }

    @Override
    public String processEmergencies(String[] tokens) throws IllegalAccessException {
        String type = tokens[1];

        List<Center> processCenters=this.centers.get(type);
        List<Emergency> emergenciesToProcess=this.emergencies.get(type);


        while (!emergenciesToProcess.isEmpty()) {
            if (processCenters.isEmpty()) {
                return String.format(
                        "%s Emergencies left to process: %d.",
                        type, emergenciesToProcess.size());
            }
            Center currentCenter = processCenters.remove(0);
            if (currentCenter.isForRetirement()) {
                continue;
            }
            Emergency currentEmergency = emergenciesToProcess.remove(0);
            currentCenter.addEmergency(currentEmergency);
            //currentEmergency.setProcessed(true);
            this.dispatchEmergencyTypeCount(currentEmergency);

            processCenters.add(currentCenter);
            this.totalProcessedEmergencies++;
        }
        return String.format(
                "Successfully responded to all %s emergencies.", type);

    }

    private void dispatchEmergencyTypeCount(Emergency emergency) throws IllegalAccessException {
        if ("HealthEmergency".equals(emergency.getClass().getSimpleName())) {
            Class propEmerg = HealthEmergency.class;
            Field casualitiesField = propEmerg.getDeclaredFields()[0];
            casualitiesField.setAccessible(true);
            int res = (Integer) casualitiesField.get(emergency);
            this.healthCasualtiesSaved += res;


        } else if ("PropertyEmergency".equals(emergency.getClass().getSimpleName())) {
            Class propEmerg = PropertyEmergency.class;
            Field damageField = propEmerg.getDeclaredFields()[0];
            damageField.setAccessible(true);
            int res = (Integer) damageField.get(emergency);
            this.propertyDamageFixed += res;
        } else {
            Class orderEmerg = OrderEmergency.class;
            Field statusField = orderEmerg.getDeclaredFields()[0];
            statusField.setAccessible(true);
            EmergencyStatus stat = (EmergencyStatus) statusField.get(emergency);

            if (stat.name().equals("Special")) {
                this.specialCasesProcessed++;
            }
        }
    }

    private int waitingEmergencies(){
        int res=0;
        for (List<Emergency> emergencyList : emergencies.values()) {
            res+=emergencyList.stream().filter(e->!e.isProcessed()).count();
        }
        return res;
    }


    @Override
    public String emergencyReport() {

        this.countActivesCenters();

        StringBuilder res = new StringBuilder();
        res.append("PRRM Services Live Statistics")
                .append(System.lineSeparator())
                .append(String.format("Fire Service Centers: %d", this.fireCentersCount))
                .append(System.lineSeparator())
                .append(String.format("Medical Service Centers: %d", this.medicalCentersCount))
                .append(System.lineSeparator())
                .append(String.format("Police Service Centers: %d", this.orderCentersCount))
                .append(System.lineSeparator())
                .append(String.format("Total Processed Emergencies: %d", this.totalProcessedEmergencies))
                .append(System.lineSeparator())
                .append(String.format("Currently Registered Emergencies: %d", this.waitingEmergencies()))
                .append(System.lineSeparator())
                .append(String.format("Total Property Damage Fixed: %d", this.propertyDamageFixed))
                .append(System.lineSeparator())
                .append(String.format("Total Health Casualties Saved: %d", this.healthCasualtiesSaved))
                .append(System.lineSeparator())
                .append(String.format("Total Special Cases Processed: %d", this.specialCasesProcessed));


        return res.toString();
    }


    private void countActivesCenters() {

        this.fireCentersCount = (int)this.centers.get("Property").stream().filter(c->!c.isRemoved()).count();
        this.medicalCentersCount = (int)this.centers.get("Health").stream().filter(c->!c.isRemoved()).count();
        this.orderCentersCount = (int)this.centers.get("Order").stream().filter(c->!c.isRemoved()).count();
    }
}
