package pb8_PetClinics;

public class Pet {
    private String name;
    private Integer age;
    private String kind;

    public Pet(String name, Integer age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(this.name);
        res.append(" ")
                .append(this.age)
                .append(" ")
                .append(this.kind);
        return res.toString();
    }
}
