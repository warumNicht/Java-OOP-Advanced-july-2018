package pb8_PetClinics;

import java.util.HashMap;

public class ClinicManager {
    private HashMap<String,Pet> pets;
    private HashMap<String, Clinic> clinics;

    public ClinicManager() {
        this.pets=new HashMap<>();
        this.clinics=new HashMap<>();
    }

    public void createPet(String name,int age, String kind){
        Pet curPet=new Pet(name,age,kind);
        this.pets.put(name,curPet);
    }

    public void createClinic(String name, int rooms){
        Clinic curClinic=new Clinic(name,rooms);
        this.clinics.put(name,curClinic);
    }

    public boolean add(String petName, String clinicName){
        Clinic curClinic=this.clinics.get(clinicName);
        Pet curPet=this.pets.get(petName);

        return curClinic.addPetByIterator(curPet);
    }

    public boolean release(String name){
        Clinic curClinic=this.clinics.get(name);
        return curClinic.releaseIterator();
    }

    public boolean hasEmpty(String name){
        Clinic curClinic=this.clinics.get(name);
        return  curClinic.hasEmptyRoom();
    }

    public void print(String name){
        Clinic curClinic=this.clinics.get(name);
        curClinic.print();
    }
    public void print(String name,int room){
        Clinic curClinic=this.clinics.get(name);
        curClinic.print(room);
    }
}
