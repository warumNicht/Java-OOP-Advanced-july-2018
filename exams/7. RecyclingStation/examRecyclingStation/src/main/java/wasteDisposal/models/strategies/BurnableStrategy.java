package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class BurnableStrategy extends AbstractStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyProduced=garbage.getVolumePerKg()*garbage.getWeight()*80/100.0;
        double capitalEarned=0;

        ProcessingData productData=new ProcessingDataImpl(energyProduced,capitalEarned);

        return productData;
    }
}
