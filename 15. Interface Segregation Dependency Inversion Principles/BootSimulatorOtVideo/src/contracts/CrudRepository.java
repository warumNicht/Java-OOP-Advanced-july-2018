package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

public interface CrudRepository<T extends Modelable> {
    T findByModel(String model) throws NonExistentModelException;

    void add(T item) throws DuplicateModelException;
}
