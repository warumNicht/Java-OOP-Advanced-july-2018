package hell.entities.models;

import hell.entities.models.heroes.Assassin;
import hell.entities.models.heroes.Barbarian;
import hell.entities.models.heroes.Wizard;
import hell.entities.models.items.CommonItem;
import hell.entities.models.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class HeroManager {
    private Map<String, Hero> heroes;

    public HeroManager() {
        this.heroes = new LinkedHashMap<>();
    }

    private static Comparator<? super Hero> getHeroesComparator() {

        return (hero1, hero2) -> {
            long firstComparatorSumHero1 = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
            long firstComparatorSumHero2 = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

            int comparatorByFirstSum = Long.compare(firstComparatorSumHero2, firstComparatorSumHero1);

            if (comparatorByFirstSum != 0) {
                return comparatorByFirstSum;
            }
            long secondComparatorSumHero1 = hero1.getHitPoints() + hero1.getDamage();
            long secondComparatorSumHero2 = hero2.getHitPoints() + hero2.getDamage();

            return Long.compare(secondComparatorSumHero2, secondComparatorSumHero1);
        };
    }

    public String addHero(String heroName, String heroType) {

        Hero hero = null;
        switch (heroType) {
            case "Barbarian": {
                hero = new Barbarian(heroName);
            }
            break;
            case "Assassin": {
                hero = new Assassin(heroName);
            }
            break;
            case "Wizard": {
                hero = new Wizard(heroName);
            }
            break;
        }
        this.heroes.put(heroName, hero);
        return String.format("Created %s - %s",
                hero.getClass().getSimpleName(), heroName);
    }

    public String addItem(String name, String heroName, int strengthBonus, int agilityBonus,
                          int intelligenceBonus, int hitPointsBonus, int damageBonus) {

        Hero hero = this.heroes.get(heroName);
        Item item = new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

        hero.addItem(item);
        return String.format("Added item - %s to Hero - %s", item.getName(), heroName);
    }

    public String addRecipe(String name, String heroName, int strengthBonus, int agilityBonus,
                            int intelligenceBonus, int hitPointsBonus, int damageBonus,
                            List<String> items) {

        Hero hero = this.heroes.get(heroName);
        Recipe recipe = new RecipeItem(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus, items);
        hero.addRecipe(recipe);

        return String.format("Added recipe - %s to Hero - %s", name, heroName);
    }

    public String inspect(String heroName) {

        Hero hero = this.heroes.get(heroName);

        StringBuilder res = new StringBuilder();
        res.append(String.format("Hero: %s, Class: %s", hero.getName(), hero.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints(), hero.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", hero.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", hero.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", hero.getIntelligence()))
                .append(System.lineSeparator());

        Collection<Item> items = hero.getItems();
        if (items.isEmpty()) {
            res.append("Items: None");
        } else {
            res.append("Items:")
                    .append(System.lineSeparator());

            for (Item item : items) {
                res.append(item.toString())
                        .append(System.lineSeparator());
            }
        }
        return res.toString().trim();
    }

    public String quit() {


        StringBuilder heroesInfo = new StringBuilder();
        final int[] index = {1};
        heroes.values()
                .stream()
                .sorted(getHeroesComparator())
                .forEach(hero -> {
                    String items = hero.getItems().size() == 0 ?

                            "None" :
                            hero.getItems()
                                    .stream()
                                    .map(Item::getName)
                                    .collect(Collectors.joining(", "));

                    heroesInfo
                            .append(String.format("%d. %s: %s",
                                    index[0]++,
                                    hero.getClass().getSimpleName(),
                                    hero.getName()))

                            .append(System.lineSeparator())
                            .append(String.format("###HitPoints: %d", hero.getHitPoints()))
                            .append(System.lineSeparator())
                            .append(String.format("###Damage: %d", hero.getDamage()))
                            .append(System.lineSeparator())
                            .append(String.format("###Strength: %d", hero.getStrength()))
                            .append(System.lineSeparator())
                            .append(String.format("###Agility: %d", hero.getAgility()))
                            .append(System.lineSeparator())
                            .append(String.format("###Intelligence: %d", hero.getIntelligence()))
                            .append(System.lineSeparator())
                            .append(String.format("###Items: %s", items))
                            .append(System.lineSeparator());

                });


        return heroesInfo.toString().trim();
    }
}
