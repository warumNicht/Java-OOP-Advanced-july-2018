package models;

import Utility.Constants;
import Utility.Validator;
import contracts.IRace;
import exeptions.DuplicateModelException;
import models.boats.Boat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Race implements IRace {
    private int distance;
    private int windSpeed;
    private int oseanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private LinkedHashMap<String, Boat> registeredBoats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOseanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<String, Boat>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oseanCurrentSpeed;
    }

    private void setOseanCurrentSpeed(int oseanCurrentSpeed) {
        this.oseanCurrentSpeed = oseanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    protected HashMap<String, Boat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    public void AddParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        if(this.allowsMotorBoats==false){
            if(boat.isMotorBoot()){
                throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
            }
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> GetParticipants() {
        return new ArrayList<Boat>(this.registeredBoats.values());
    }
}