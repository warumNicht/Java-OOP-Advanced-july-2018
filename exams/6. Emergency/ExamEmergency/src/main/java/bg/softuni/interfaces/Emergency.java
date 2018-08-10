package bg.softuni.interfaces;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public interface Emergency {
    boolean isProcessed();

    void setProcessed(boolean processed);

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    String  getRegistrationTime();
}
