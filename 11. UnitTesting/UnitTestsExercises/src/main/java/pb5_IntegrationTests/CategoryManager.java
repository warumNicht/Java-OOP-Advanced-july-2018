package pb5_IntegrationTests;
import java.util.HashMap;

public class CategoryManager {
    private HashMap<String, Category> storedCategories;
    private HashMap<String, User> storedUsers;

    public CategoryManager() {
        this.storedCategories = new HashMap<>();
        this.storedUsers = new HashMap<>();
    }

    public void addUserToTable(User user){
        this.storedUsers.put(user.getName(),user);
    }
    public void addCategoryToTable(Category category){
        this.storedCategories.put(category.getName(),category);
    }
    public void addUserToCategory(String userName,String categoryName){
        if(this.storedUsers.containsKey(userName)&&this.storedCategories.containsKey(categoryName)){
            this.storedUsers.get(userName).addCategory(this.storedCategories.get(categoryName));
            this.storedCategories.get(categoryName).addUserToCategory(this.storedUsers.get(userName));
        }else {
            throw new IllegalArgumentException("Category or user does not exists!");
        }
    }
    public void addSubcategory(String targetCategoryName,String subcategoryName){
        if(this.storedCategories.containsKey(targetCategoryName)&&this.storedCategories.containsKey(subcategoryName)){
            Category current=this.storedCategories.get(subcategoryName);
            this.storedCategories.get(targetCategoryName).assignSubcategory(current);
        }else {
            throw new IllegalArgumentException("Categories does not exists!");
        }
    }

    public void removeCategoryFromTable(String categoryName){
        if(this.storedCategories.containsKey(categoryName)){

            Category categoryToRemove=this.storedCategories.get(categoryName);

            deassingUsersFromCategoryToRemove(categoryToRemove);
            assignSubcategoriesToUsers(categoryToRemove);
            assignUsersToSubcategories(categoryToRemove);
            this.storedCategories.remove(categoryName);

        }else {
            throw new IllegalArgumentException("Category does not exists!");
        }
    }

    public void moveSubcategory(String targetCategory,String originCategory){
        if (this.storedCategories.containsKey(targetCategory)&&
                this.storedCategories.containsKey(originCategory)){
            Category target=this.storedCategories.get(targetCategory);
            Category origin=this.storedCategories.get(originCategory);
            for (Category category : storedCategories.values()) {
                category.getSubCategories().remove(origin);
            }
            target.getSubCategories().add(origin);

        }else {
            throw new IllegalArgumentException("Categories does not exists!");
        }
    }

    private void assignSubcategoriesToUsers(Category categoryToRemove) {
        for (User user : categoryToRemove.getUsers()) {
            for (Category category : categoryToRemove.getSubCategories()) {
                user.addCategory(category);
            }
        }
    }
    private void assignUsersToSubcategories(Category categoryToRemove) {
        for (Category category : categoryToRemove.getSubCategories()) {
            for (User user : categoryToRemove.getUsers()) {
                category.addUserToCategory(user);
            }
        }
    }

    private void deassingUsersFromCategoryToRemove(Category categoryToRemove) {
        for (User user : categoryToRemove.getUsers()) {
            user.removeCategory(categoryToRemove);
        }
    }

}
