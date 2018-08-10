package wasteDisposal.models.strategies;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.ProcessingDataImpl;

public class StorableStrategy extends AbstractStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyUsed=(-1)*garbage.getVolumePerKg()*garbage.getWeight()*0.13;
        double capitalUsed=(-1)*garbage.getWeight()*garbage.getVolumePerKg()*0.65;

        ProcessingData productData=new ProcessingDataImpl(energyUsed,capitalUsed);

        return productData;
    }
}
