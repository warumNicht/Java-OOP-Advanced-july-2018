package wasteDisposal.models.wasts;

import wasteDisposal.annotations.Burning;

@Burning
public class Burnable extends AbstractWaste {
    public Burnable(String...arguments) {
        super(arguments);
    }

}
