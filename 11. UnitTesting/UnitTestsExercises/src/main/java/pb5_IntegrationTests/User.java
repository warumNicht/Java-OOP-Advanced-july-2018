package pb5_IntegrationTests;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Set<Category> categories;

    public User(String name) {
        this.name = name;
        this.categories = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof User)){
            return false;
        }
        if(obj==this){
            return true;
        }
        return this.name.equals( ((User)obj).name );
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
