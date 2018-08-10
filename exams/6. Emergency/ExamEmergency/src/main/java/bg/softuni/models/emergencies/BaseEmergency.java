package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Emergency;
import bg.softuni.utils.RegistrationTime;

public  abstract class BaseEmergency implements Emergency {
    private String description;

    private EmergencyLevel emergencyLevel;

    private String  registrationTime;
    private boolean isProcessed;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, String  registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }
    @Override
    public boolean isProcessed() {
        return isProcessed;
    }
    @Override
    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }
    @Override
    public String  getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(String  registrationTime) {
        this.registrationTime = registrationTime;
    }
}
