package wasteDisposal.models.wasts;

import wasteDisposal.annotations.Recyling;

@Recyling
public class Recyclable extends AbstractWaste {
    public Recyclable(String...arguments) {
        super(arguments);
    }
}
