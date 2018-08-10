package softuni.models.entities;

import softuni.interfaces.Fragment;
import softuni.models.entities.cores.AbstractCore;
import softuni.models.entities.cores.ParaCore;
import softuni.models.entities.cores.SystemCore;
import softuni.models.entities.fragments.BaseFragment;
import softuni.models.entities.fragments.CoolingFragment;
import softuni.models.entities.fragments.NuclearFragment;

import java.util.LinkedHashMap;

public class CoreManager {
    private LinkedHashMap<String, AbstractCore> cores;
    private AbstractCore selectedCore;

    public CoreManager() {
        this.cores = new LinkedHashMap<>();
        this.selectedCore = null;
    }

    public String addCore(String type, Integer durability) {
        AbstractCore core = null;
        if ("System".equals(type)) {
            try {
                core = new SystemCore(durability);
                this.cores.put(core.getName(), core);
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }

        } else if ("Para".equals(type)) {
            try {
                core = new ParaCore(durability);
                this.cores.put(core.getName(), core);
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }

        return core == null ? "Failed to create Core!" : String.format("Successfully created Core %s!", core.getName());
    }

    public String selectCore(String coreName) {
        if (this.cores.containsKey(coreName)) {
            this.selectedCore = this.cores.get(coreName);
            return String.format("Currently selected Core %s!", coreName);
        } else {
            return String.format("Failed to select Core %s.", coreName);
        }
    }

    public String attachFragment(String type, String name, Integer pressure) {
        if ("Nuclear".equals(type) == false && "Cooling".equals(type) == false
                || pressure < 0 || this.selectedCore == null) {
            return String.format("Failed to attach Fragment %s!", name);
        }
        AbstractCore core = this.selectedCore;
        BaseFragment fragment = null;
        if ("Nuclear".equals(type)) {
            fragment = new NuclearFragment(name, pressure);
        } else {
            fragment = new CoolingFragment(name, pressure);
        }

        core.addFragment(fragment);

        return String.format("Successfully attached Fragment %s to Core %s!",
                name, core.getName());
    }

    public String dettachFragment() {
        AbstractCore core = this.selectedCore;
        if (this.selectedCore == null || core.getListStack().isEmpty()) {
            return "Failed to detach Fragment!";
        }
        Fragment fragment=core.getListStack().pop();

        return String.format("Successfully detached Fragment %s from Core %s!",
                fragment.getName(), core.getName());
    }

    public String status() {
        StringBuilder res=new StringBuilder();
        res.append("Lambda Core Power Plant Status:")
                .append(System.lineSeparator())
                .append(String.format("Total Durability: %s",
                        this.getTotalDurability()))
                .append(System.lineSeparator())
                .append(String.format("Total Cores: %d",this.cores.size()))
                .append(System.lineSeparator())
                .append(String.format("Total Fragments: %d",
                        this.getTotalFragmentCount()))
                .append(System.lineSeparator());

        for (AbstractCore core : cores.values()) {
            res.append(core)
                    .append(System.lineSeparator());
        }

        return res.toString().trim();
    }
    private int getTotalDurability(){
        int res=0;
        for (AbstractCore core : cores.values()) {
            res+=core.checkDurabulity();
        }
        return res;
    }
    private  int getTotalFragmentCount(){
        int res=0;
        for (AbstractCore core : cores.values()) {
            res+=core.getListStack().size();
        }
        return res;
    }

    public String removeCore(String token) {
        if(this.cores.containsKey(token)){
            this.cores.remove(token);

            if(this.selectedCore.getName().equals(token)){
                this.selectedCore=null;
            }
            return String.format("Successfully removed Core %s!",token);
        }
        return null;
    }
}
