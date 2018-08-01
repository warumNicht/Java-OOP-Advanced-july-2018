package pb7_1984.models;

import pb7_1984.interfaces.Subject;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class BaseSubject implements Subject {
    private String id;
    private String name;

    protected BaseSubject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public <T> void  update(List<Institution> institutions, String field, T newValue) throws NoSuchFieldException, IllegalAccessException {

        Field fieldToChange=null;

        if("name".equals(field)){
            fieldToChange=this.getClass().getSuperclass().getDeclaredField(field);
        }else {
            fieldToChange=this.getClass().getDeclaredField(field);
        }
        String fieldType=fieldToChange.getType().getSimpleName();
        fieldToChange.setAccessible(true);
        T oldValue=(T)fieldToChange.get(this);

        fieldToChange.set(this,newValue);



        for (Institution institution : institutions) {
            institution.registerChanges(this,field,fieldType,oldValue,newValue);
        }

    }
}
