package wasteDisposal.factory;

import wasteDisposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WasteFactory {
    private static final String PATH_TO_MODELS ="wasteDisposal.models.wasts.";


    public Waste createWast(String...arguments) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Waste waste=null;

        String modelPath=PATH_TO_MODELS+arguments[3];
        Class modelWaste=Class.forName(modelPath);
        Constructor constructor=modelWaste.getDeclaredConstructors()[0];
        waste= (Waste) constructor.newInstance((Object) arguments);

        return waste;
    }
}
