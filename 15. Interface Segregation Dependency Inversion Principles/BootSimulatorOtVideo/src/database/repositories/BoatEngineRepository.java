package database.repositories;

import Utility.Constants;
import contracts.BoatEngine;
import contracts.CrudRepository;
import contracts.Modelable;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository<T extends Modelable> implements CrudRepository<BoatEngine> {
    private Map<String, BoatEngine> boatsEngines;

    public BoatEngineRepository() {
        this.boatsEngines =new LinkedHashMap<>();
    }
//
//    @Override
//    public Map<String, BoatEngine> getBoatsEngines() {
//        return Collections.unmodifiableMap(this.boatsEngines);
//    }

    @Override
    public void add(BoatEngine item) throws DuplicateModelException {
        if (this.boatsEngines.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.boatsEngines.put(item.getModel(),item);
    }

    @Override
    public BoatEngine findByModel(String model) throws NonExistentModelException {
        if (!this.boatsEngines.containsKey(model)) {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.boatsEngines.get(model);
    }

}
