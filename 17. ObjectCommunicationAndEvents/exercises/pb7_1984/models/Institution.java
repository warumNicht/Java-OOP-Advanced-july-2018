package pb7_1984.models;

import pb7_1984.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Institution {
    private String id;
    private String name;
    private List<String> subjects;
    private List<String> registeredChanges;

    public Institution(String id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.registeredChanges = new ArrayList<>();
    }
    public <T> void registerChanges(Subject subject,String field,String fieldType,T oldValue,T newValue){
        if(this.subjects.contains(field)){
            String change=String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
                    subject.getClass().getSimpleName(),subject.getId(),field,
                    fieldType,oldValue,newValue);

            this.registeredChanges.add(change);
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("%s: %d changes registered", this.name,this.registeredChanges.size()))
                .append(System.lineSeparator());
        for (String registeredChange : registeredChanges) {
            res.append(registeredChange)
                    .append(System.lineSeparator());
        }
        return res.toString().trim();
    }
}
