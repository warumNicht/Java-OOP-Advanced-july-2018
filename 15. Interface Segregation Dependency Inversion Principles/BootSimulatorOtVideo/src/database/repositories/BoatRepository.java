package database.repositories;

import Utility.Constants;
import contracts.Boat;
import contracts.CrudRepository;
import contracts.Modelable;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository<T extends Modelable> implements CrudRepository<Boat> {
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats=new LinkedHashMap<>();
    }

//    @Override
//    public Map<String, Boat> getBoatsEngines() {
//        return Collections.unmodifiableMap(this.boats);
//    }

    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.boats.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.boats.put(item.getModel(),item);
    }

    @Override
    public Boat findByModel(String model) throws NonExistentModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.boats.get(model);
    }

}
