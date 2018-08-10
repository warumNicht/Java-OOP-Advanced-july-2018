package bg.softuni.models.centers;

import bg.softuni.enums.EmergType;
import bg.softuni.interfaces.Center;
import bg.softuni.interfaces.Emergency;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmergencyCenter implements Center {
    private String name;
    private Integer amountOfMaximumEmergencies;
    private List<Emergency> emergencies;
    private EmergType emergType;
    private  int currentSize;
    private boolean isRemoved;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.emergencies=new ArrayList<>();
    }

    protected void setEmergType(EmergType emergType) {
        this.emergType = emergType;
    }
    @Override
    public EmergType getEmergType() {
        return emergType;
    }
    @Override
    public void addEmergency(Emergency emergency){
        this.emergencies.add(emergency);
        this.currentSize++;
        if(this.currentSize==this.amountOfMaximumEmergencies){
            this.isRemoved=true;
        }
    }
    @Override
    public boolean isRemoved() {
        return isRemoved;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }
    @Override
    public  Boolean isForRetirement(){
        return this.currentSize>=this.amountOfMaximumEmergencies;
    }
}
