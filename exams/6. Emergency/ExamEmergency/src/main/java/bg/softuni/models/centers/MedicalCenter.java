package bg.softuni.models.centers;

import bg.softuni.enums.EmergType;

public class MedicalCenter extends BaseEmergencyCenter {
    public MedicalCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        super.setEmergType(EmergType.Health);
    }
}
