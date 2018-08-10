package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.enums.EmergencyStatus;
import bg.softuni.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency{
    private EmergencyStatus status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, String  registrationTime, EmergencyStatus status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }
}
