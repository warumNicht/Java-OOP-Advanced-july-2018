package pb5_IntegrationTests;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private String name;
    private Set<User> users;
    private Set<Category> subCategories;

    public Category(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.subCategories = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void addUserToCategory(User user){
        this.users.add(user);
    }
    public void assignSubcategory(Category category){
        this.subCategories.add(category);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Category)){
            return false;
        }
        if(obj==this){
            return true;
        }
        return this.name.equals(((Category) obj).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
