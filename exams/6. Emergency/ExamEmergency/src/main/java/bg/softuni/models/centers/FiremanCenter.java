package bg.softuni.models.centers;

import bg.softuni.enums.EmergType;

public class FiremanCenter extends BaseEmergencyCenter {
    public FiremanCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        super.setEmergType(EmergType.Property);
    }
}
