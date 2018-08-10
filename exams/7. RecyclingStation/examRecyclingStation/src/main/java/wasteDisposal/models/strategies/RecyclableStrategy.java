package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class RecyclableStrategy extends AbstractStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyUsed=(-1)*garbage.getWeight()*garbage.getVolumePerKg()/2.0;
        double capitalEarned=garbage.getWeight()*400;

        ProcessingData productData=new ProcessingDataImpl(energyUsed,capitalEarned);

        return productData;
    }
}
