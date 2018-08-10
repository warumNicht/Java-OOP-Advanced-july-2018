package bg.softuni.interfaces;

import bg.softuni.enums.EmergType;

public interface Center {
    EmergType getEmergType();

    void addEmergency(Emergency emergency);

    boolean isRemoved();

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();
}
