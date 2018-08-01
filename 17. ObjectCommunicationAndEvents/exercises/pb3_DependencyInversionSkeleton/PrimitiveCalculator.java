package pb3_DependencyInversionSkeleton;


import pb3_DependencyInversionSkeleton.strategies.AdditionStrategy;
import pb3_DependencyInversionSkeleton.strategies.DivideStrategy;
import pb3_DependencyInversionSkeleton.strategies.MultiplyStrategy;
import pb3_DependencyInversionSkeleton.strategies.SubtractionStrategy;

public class PrimitiveCalculator {

    private CalculationStrategy strategy;

    public PrimitiveCalculator(){
        this.strategy=new AdditionStrategy();
    }

    public void changeStrategy(char operator){
        switch (operator){
            case '+': this.strategy=new AdditionStrategy();
                break;
            case '-':this.strategy=new SubtractionStrategy();
                break;
            case '/':this.strategy=new DivideStrategy();
                break;
            case '*':this.strategy=new MultiplyStrategy();
                break;
        }
    }

    public int performCalculation(int firstOperand,int secondOperand){

        return this.strategy.calculate(firstOperand,secondOperand);
    }
}
