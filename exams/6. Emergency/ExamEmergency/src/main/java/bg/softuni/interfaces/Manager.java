package bg.softuni.interfaces;

public interface Manager {
    String registerPropertyEmergency(String[] tokens);

    String registerHealthEmergency(String[] tokens);

    String registerOrderEmergency(String[] tokens);

    String registerFireServiceCenter(String[] tokens);

    String registerMedicalServiceCenter(String[] tokens);

    String registerPoliceServiceCenter(String[] tokens);

    String processEmergencies(String[] tokens) throws IllegalAccessException;

    String emergencyReport();
}
