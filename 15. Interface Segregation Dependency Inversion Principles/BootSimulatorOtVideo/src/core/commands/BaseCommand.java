package core.commands;

import annotations.Inject;
import contracts.BoatSimulatorController;
import contracts.Executable;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable {

    @Inject
    private List<String> params;
    @Inject
    private BoatSimulatorController controller;


    protected BaseCommand() {
    }

    public List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected BoatSimulatorController getController() {
        return controller;
    }
}

