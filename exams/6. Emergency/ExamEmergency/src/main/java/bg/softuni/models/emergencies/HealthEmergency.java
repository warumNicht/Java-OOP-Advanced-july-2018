package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency{
    private int casualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, String registrationTime, int casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }
}
