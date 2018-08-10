package wasteDisposal.models.strategies;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

public abstract class AbstractStrategy implements GarbageDisposalStrategy {
    @Override
    public abstract ProcessingData processGarbage(Waste garbage);
}
