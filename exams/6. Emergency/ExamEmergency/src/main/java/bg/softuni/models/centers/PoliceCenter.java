package bg.softuni.models.centers;

import bg.softuni.enums.EmergType;

public class PoliceCenter extends BaseEmergencyCenter {
    public PoliceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        super.setEmergType(EmergType.Order);
    }
}
