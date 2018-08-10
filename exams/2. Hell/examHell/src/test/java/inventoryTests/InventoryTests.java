package inventoryTests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InventoryTests {
    private static final int PROPERTY=10;
    private static final List<String> RECIPE_1_ITEMS =Arrays.asList("Earth", "Mars", "Venus");
    private static final List<String> RECIPE_2_ITEMS =new ArrayList<String>(){{
        add("Ivan");
        add("Stoqn");}};

    private Item item1;
    private Item item2;
    private Item item3;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    private Inventory inventory;

    @Before
    public  void initializeTestingObjects(){
        this.item1=Mockito.mock(Item.class);
        this.item2=Mockito.mock(Item.class);
        this.item3=Mockito.mock(Item.class);

        this.recipe1=Mockito.mock(Recipe.class);
        this.recipe2=Mockito.mock(Recipe.class);
        this.recipe3=Mockito.mock(Recipe.class);

        this.inventory=new HeroInventory();

        Mockito.when(item1.getAgilityBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getAgilityBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item3.getAgilityBonus()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(item1.getStrengthBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getStrengthBonus()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(item1.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getDamageBonus()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(item1.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(item1.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(item1.getName()).thenReturn("Ivan");
        Mockito.when(item2.getName()).thenReturn("Stoqn");
        Mockito.when(item3.getName()).thenReturn("Stamat");

        Mockito.when(recipe1.getName()).thenReturn("rrr");
        Mockito.when(recipe2.getName()).thenReturn("ttt");
        Mockito.when(recipe3.getName()).thenReturn("sss");

        Mockito.when(recipe1.getRequiredItems()).thenReturn(RECIPE_1_ITEMS);
        Mockito.when(recipe2.getRequiredItems()).thenReturn(RECIPE_2_ITEMS);
        Mockito.when(recipe3.getRequiredItems()).thenReturn(RECIPE_2_ITEMS);

        Mockito.when(recipe2.getAgilityBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe2.getStrengthBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe2.getIntelligenceBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe2.getHitPointsBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe2.getDamageBonus()).thenReturn(PROPERTY);

        Mockito.when(recipe3.getAgilityBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe3.getStrengthBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe3.getIntelligenceBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe3.getHitPointsBonus()).thenReturn(PROPERTY);
        Mockito.when(recipe3.getDamageBonus()).thenReturn(PROPERTY);
    }

    @Test
    public void testCombiningRecipe() throws IllegalAccessException {
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);
        this.inventory.addRecipeItem(this.recipe2);
        Class invenotyClass=HeroInventory.class;
        Field field=invenotyClass.getDeclaredFields()[0];
        field.setAccessible(true);

        Map<String, Item> items=(Map<String, Item>)field.get(this.inventory);
        int expectedSize=items.size();
        boolean containsRecipesName=items.containsKey(recipe2.getName());

        Item item=items.get(recipe2.getName());
        int strength=item.getStrengthBonus();
        int agility=item.getAgilityBonus();
        int intel=item.getIntelligenceBonus();
        int hit=item.getHitPointsBonus();
        int damage=item.getDamageBonus();

        Assert.assertEquals(expectedSize,1);
        Assert.assertTrue(containsRecipesName==true);

        Assert.assertEquals(PROPERTY,strength);
        Assert.assertEquals(PROPERTY,agility);
        Assert.assertEquals(PROPERTY,intel);
        Assert.assertEquals(PROPERTY,hit);
        Assert.assertEquals(PROPERTY,damage);
    }
    @Test
    public void testCombiningItemsShouldRemoveTheFirstRecipe() throws IllegalAccessException {
        this.inventory.addRecipeItem(this.recipe2);
        this.inventory.addRecipeItem(this.recipe3);
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Class invenotyClass=HeroInventory.class;
        Field field=invenotyClass.getDeclaredFields()[0];
        field.setAccessible(true);

        Map<String, Item> items=(Map<String, Item>)field.get(this.inventory);
        int expectedSize=items.size();
        boolean containsRecipesName=items.containsKey(recipe2.getName());

        Item item=items.get(recipe2.getName());
        int strength=item.getStrengthBonus();
        int agility=item.getAgilityBonus();
        int intel=item.getIntelligenceBonus();
        int hit=item.getHitPointsBonus();
        int damage=item.getDamageBonus();

        Field field2=invenotyClass.getDeclaredFields()[1];
        field2.setAccessible(true);

        Map<String, Recipe> recipies=(Map<String, Recipe>)field.get(this.inventory);
        int expectedSize2=recipies.size();

        Assert.assertEquals(expectedSize,1);
        Assert.assertTrue(containsRecipesName==true);
        Assert.assertEquals(expectedSize2,1);

        Assert.assertEquals(PROPERTY,strength);
        Assert.assertEquals(PROPERTY,agility);
        Assert.assertEquals(PROPERTY,intel);
        Assert.assertEquals(PROPERTY,hit);
        Assert.assertEquals(PROPERTY,damage);
    }
//    @Test
//    public void testCombiningItemsShouldRemoveRecipe() throws IllegalAccessException {
//        this.inventory.addCommonItem(this.item1);
//        this.inventory.addCommonItem(this.item2);
//        this.inventory.addRecipeItem(this.recipe2);
//        Class invenotyClass=HeroInventory.class;
//        Field field2=invenotyClass.getDeclaredFields()[1];
//        field2.setAccessible(true);
//
//        Map<String, Recipe> recipies=(Map<String, Recipe>)field2.get(this.inventory);
//        int expectedSize=recipies.size();
//
//        Assert.assertEquals(expectedSize,0);
//    }
    @Test
    public void testAddingItems() throws IllegalAccessException {
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);
        this.inventory.addCommonItem(this.item3);
        Class invenotyClass=HeroInventory.class;
        Field field=invenotyClass.getDeclaredFields()[0];
        field.setAccessible(true);

        int expectedSize=((Map<String, Item>)field.get(this.inventory)).size();

        Assert.assertEquals(expectedSize,3);
    }

    @Test
    public void testAddingRecipes() throws IllegalAccessException {
        this.inventory.addRecipeItem(this.recipe1);
        this.inventory.addRecipeItem(this.recipe2);
        Class invenotyClass=HeroInventory.class;
        Field field=invenotyClass.getDeclaredFields()[1];
        field.setAccessible(true);

        int expectedSize=((Map<String, Recipe>)field.get(this.inventory)).size();

        Assert.assertEquals(expectedSize,2);
    }

    @Test
    public void testGetAgylityBonus(){
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);
        this.inventory.addCommonItem(this.item3);

        Assert.assertEquals(this.inventory.getTotalAgilityBonus(),3L*Integer.MAX_VALUE);
    }

    @Test
    public void testGetStrengthBonus(){
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals(this.inventory.getTotalStrengthBonus(),2L*Integer.MAX_VALUE);
    }
    @Test
    public void testGetDamageBonus(){
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals(this.inventory.getTotalDamageBonus(),2L*Integer.MAX_VALUE);
    }
    @Test
    public void testGetIntelBonus(){
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals(this.inventory.getTotalIntelligenceBonus(),2L*Integer.MAX_VALUE);
    }
    @Test
    public void testGetHitBonus(){
        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals(this.inventory.getTotalHitPointsBonus(),2L*Integer.MAX_VALUE);
    }

}
