package pb5_TestingCategoryManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import pb5_IntegrationTests.Category;
import pb5_IntegrationTests.CategoryManager;
import pb5_IntegrationTests.User;

import java.lang.reflect.Field;
import java.util.*;

public class CategoriesManagerTests {
    private static final User[] USERS=new User[]{
            new User("Hellmut"),new User("Hans"),new User("Gan4o"),new User("Helga"),new User("Stoen4a")
    };
    private static final Category[] CATEGORIES=new Category[]{
          new Category("Spielzeug"), new Category("Haushaltwaren") , new Category("Unterhaltung"), new Category("Reiseburos")
    };
    private static final Category BEISPIEL_CATEGORY=new Category("Haushaltwaren");
    private static final Category BEISPIEL_CATEGORY_ZWEI=new Category("Spielzeug");
    private static final User BEISPIEL_USER=new User("Helga");

    private CategoryManager manager;

    @Before
    public void initializeTestingObjects(){
        this.manager=new CategoryManager();
        for (User user : USERS) {
            this.manager.addUserToTable(user);
        }
        for (Category category : CATEGORIES) {
            this.manager.addCategoryToTable(category);
        }
    }
    @Test
    public void testAddingUsers() throws NoSuchFieldException, IllegalAccessException {
        Field fieldToAccess=CategoryManager.class.getDeclaredField("storedUsers");
        fieldToAccess.setAccessible(true);
        Collection<User> expectedAddedUsers=((Map<String,User>)fieldToAccess.get(this.manager)).values();

        boolean isFound=true;
        for (User expectedUser : expectedAddedUsers) {
            boolean isFoundInSubCycle=false;
            for (User user : this.USERS) {
                if(expectedUser.equals(user)){
                    isFoundInSubCycle=true;
                }
            }
            if(isFoundInSubCycle==false){
                isFound=false;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }
    @Test
    public void testAddingCategories() throws NoSuchFieldException, IllegalAccessException {
        Field storedCategories=CategoryManager.class.getDeclaredField("storedCategories");
        storedCategories.setAccessible(true);
        Collection<Category> expectedAddedCategories=( (Map<String,Category>)storedCategories.get(this.manager) ).values();

        boolean isFound=true;
        for (Category expectedUser : expectedAddedCategories) {
            boolean isFoundInSubCycle=false;
            for (Category user : this.CATEGORIES) {
                if(expectedUser.equals(user)){
                    isFoundInSubCycle=true;
                }
            }
            if(isFoundInSubCycle==false){
                isFound=false;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }
    @Test
    public void testRemovingCategory() throws NoSuchFieldException, IllegalAccessException {
        String categoryNameToBeRemoved = "Spielzeug";
        Category[] expectedCategories=new Category[]{new Category("Haushaltwaren") , new Category("Unterhaltung"), new Category("Reiseburos")};

        Field field=CategoryManager.class.getDeclaredField("storedCategories");
        field.setAccessible(true);
        this.manager.removeCategoryFromTable(categoryNameToBeRemoved);

        Map<String,Category> containedCat=(Map<String,Category>)field.get(this.manager);

        Category[] stored=containedCat.values().toArray(new Category[expectedCategories.length]);

        Assert.assertArrayEquals(expectedCategories,stored);
    }
    @Test
    public void testAssigningUserToCategory() throws NoSuchFieldException, IllegalAccessException {
        String userName=BEISPIEL_USER.getName();
        String category=BEISPIEL_CATEGORY.getName();
        Field field=CategoryManager.class.getDeclaredField("storedCategories");
        field.setAccessible(true);
        Map<String,Category> containedCat=(Map<String,Category>)field.get(this.manager);
        Category expectedCategory=containedCat.get(category);
        this.manager.addUserToCategory(userName,category);

        Field catField=Category.class.getDeclaredField("users");
        catField.setAccessible(true);

        Set<User> expectedUsers=(HashSet<User>)(catField.get(expectedCategory));


        Assert.assertTrue(expectedUsers.contains(BEISPIEL_USER));
    }
    @Test
    public void testAssigningChildCategoryToParentCategory() throws NoSuchFieldException, IllegalAccessException {
        this.manager.addSubcategory(BEISPIEL_CATEGORY.getName(),BEISPIEL_CATEGORY_ZWEI.getName());

        Field field=CategoryManager.class.getDeclaredField("storedCategories");
        field.setAccessible(true);
        Map<String,Category> containedCat=(Map<String,Category>)field.get(this.manager);
        Category expectedCategory=containedCat.get(BEISPIEL_CATEGORY.getName());

        Field catField=Category.class.getDeclaredField("subCategories");
        catField.setAccessible(true);

        Set<Category> expectedCategories=(HashSet<Category>)(catField.get(expectedCategory));

        Assert.assertTrue(expectedCategories.contains(BEISPIEL_CATEGORY_ZWEI));
    }
    @Test
    public void testRemovingCategoryAssignUsersToSubCategory() throws NoSuchFieldException, IllegalAccessException {

        this.manager.addUserToCategory(BEISPIEL_USER.getName(),BEISPIEL_CATEGORY.getName());
        this.manager.addSubcategory(BEISPIEL_CATEGORY.getName(),BEISPIEL_CATEGORY_ZWEI.getName());
        this.manager.removeCategoryFromTable(BEISPIEL_CATEGORY.getName());

        Field field=CategoryManager.class.getDeclaredField("storedCategories");
        field.setAccessible(true);
        Map<String,Category> containedCat=(Map<String,Category>)field.get(this.manager);
        Category expectedCategory=containedCat.get(BEISPIEL_CATEGORY_ZWEI.getName());

        Field catField=Category.class.getDeclaredField("users");
        catField.setAccessible(true);

        Set<User> expectedUsers=(HashSet<User>)(catField.get(expectedCategory));


        Assert.assertTrue(expectedUsers.contains(BEISPIEL_USER));
    }
}
