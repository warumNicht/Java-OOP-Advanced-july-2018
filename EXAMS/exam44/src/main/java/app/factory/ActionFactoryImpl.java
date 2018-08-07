package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if("OneVsOne".equals(actionName)){
               return new OneVsOne(participantNames);
        }else  if("BossFight".equals(actionName)){
            return new BossFight(participantNames);
        }else {
            throw new ClassNotFoundException("Action does not exist.");
        }


    }
}
