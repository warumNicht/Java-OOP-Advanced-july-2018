package wasteDisposal.models.wasts;

import wasteDisposal.annotations.Storing;

@Storing
public class Storable extends AbstractWaste {
    public Storable(String...arguments) {
        super(arguments);
    }
}
