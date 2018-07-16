package pb7_EqualityLogic;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.getName().compareTo(person.getName()) == 0) {
            return this.getAge() - person.getAge();
        }
        return this.getName().compareTo(person.getName());
    }


    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 19 * hashCode + (this.name != null ? this.name.hashCode() : 0);
        hashCode = 19 * hashCode + this.age;

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

}

