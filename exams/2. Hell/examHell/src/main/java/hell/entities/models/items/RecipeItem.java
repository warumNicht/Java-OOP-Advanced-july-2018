package hell.entities.models.items;

import hell.interfaces.Recipe;

import java.util.Collections;
import java.util.List;

public class RecipeItem extends AbstractItem implements Recipe {
    private List<String> commonItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> commonItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.commonItems = commonItems;
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.commonItems);
    }
}
