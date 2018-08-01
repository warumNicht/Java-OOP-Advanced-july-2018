package pb3_DependencyInversionSkeleton.strategies;

import pb3_DependencyInversionSkeleton.CalculationStrategy;

public class SubtractionStrategy implements CalculationStrategy {
    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
