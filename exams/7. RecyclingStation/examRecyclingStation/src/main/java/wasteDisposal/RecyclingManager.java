package wasteDisposal;

import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.factory.WasteFactory;

import java.lang.reflect.InvocationTargetException;

public class RecyclingManager {
    private double energySaldo;
    private double capitalSaldo;
    private GarbageProcessor garbageProcessor;
    private WasteFactory wasteFactory;

    private double requiredEnergy;
    private double requiredCapital;
    private String deniedType;

    public RecyclingManager(GarbageProcessor garbageProcessor, WasteFactory wasteFactory) {
        this.energySaldo = 0;
        this.capitalSaldo = 0;
        this.garbageProcessor = garbageProcessor;
        this.wasteFactory=wasteFactory;
    }

    public String processGarbage(String[] tokens) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Waste waste=this.wasteFactory.createWast(tokens);
        ProcessingData product= this.garbageProcessor.processWaste(waste);

        double productEnergy=product.getEnergyBalance();
        double productCapital=product.getCapitalBalance();

        if(this.deniedType!=null&&this.deniedType.equals(waste.getClass().getSimpleName())){
            if(this.energySaldo<this.requiredEnergy||this.capitalSaldo<this.requiredCapital){
                return "Processing Denied!";
            }
        }

        this.energySaldo+=product.getEnergyBalance();
        this.capitalSaldo+=product.getCapitalBalance();

        return String.format("%.2f kg of %s successfully processed!", waste.getWeight(),waste.getName());
    }

    public String status() {
        return String.format("Energy: %.2f Capital: %.2f", this.energySaldo,this.capitalSaldo);
    }
    public String changeManagementRequirement(String[] arguments) {
        this.requiredEnergy=Double.parseDouble(arguments[0]);
        this.requiredCapital=Double.parseDouble(arguments[1]);
        this.deniedType=arguments[2];

        return "Management requirement changed!";
    }
}
