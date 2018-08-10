package hell.entities.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public  abstract class AbstractHero implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints ;
    private int damage;

    private Inventory inventory;

    protected AbstractHero(String name) {
        this.name = name;
        this.strength = 0;
        this.agility = 0;
        this.intelligence = 0;
        this.hitPoints = 0;
        this.damage = 0;
        this.inventory = new HeroInventory();
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength+this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility+this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence+this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints+this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage+this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        Class wantedClass=this.inventory.getClass();
        Field itemsField=wantedClass.getDeclaredFields()[0];
        itemsField.setAccessible(true);
        try {
            Map<String, Item> commonItems = (Map<String, Item>) itemsField.get(this.inventory);

            return commonItems.values();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();

        res.append(String.format("%s: %s",this.getClass().getSimpleName(),this.name))
                .append(System.lineSeparator())
                .append(String.format("###HitPoints: %d", this.getHitPoints()))
                .append(System.lineSeparator())
                .append(String.format("###Damage: %d",this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("###Strength: %d",this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("###Agility: %d",this.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("###Intelligence: %d",this.getIntelligence()))
                .append(System.lineSeparator());


        List<String> items=this.getItems().stream()
                .map(x->x.getName())
                .collect(Collectors.toList());

        res.append(String.format("###Items: %s", items.isEmpty() ? "None" : String.join(", ",items)));

        return res.toString().trim();
    }
}
