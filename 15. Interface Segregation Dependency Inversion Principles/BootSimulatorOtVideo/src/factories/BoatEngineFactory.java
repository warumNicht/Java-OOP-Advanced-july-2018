package factories;

import contracts.BoatEngine;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;

public final class BoatEngineFactory {
    private BoatEngineFactory() {
    }

    public static BoatEngine createJetEngine(String model,int horsepower,int displacement){
        return new JetEngine(model,horsepower,displacement);
    }
    public static BoatEngine createSterndriveEngine(String model,int horsepower,int displacement){
        return new SterndriveEngine(model,horsepower,displacement);
    }
}
