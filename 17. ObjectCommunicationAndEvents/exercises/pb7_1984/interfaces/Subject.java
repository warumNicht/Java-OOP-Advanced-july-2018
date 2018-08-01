package pb7_1984.interfaces;

import pb7_1984.models.Institution;

import java.util.List;

public interface Subject {
    String getId();

    String getName();

    <T> void  update(List<Institution> institutions, String field, T newValue) throws NoSuchFieldException, IllegalAccessException;
}
