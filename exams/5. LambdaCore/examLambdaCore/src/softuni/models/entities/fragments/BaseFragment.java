package softuni.models.entities.fragments;

import softuni.interfaces.Fragment;
import softuni.models.enums.FragmentType;

public abstract class BaseFragment implements Fragment {

    private String name;
    private FragmentType type;
    private Integer pressureAffection;

    protected BaseFragment(String name) {
        this.setName(name);
    }
    @Override
    public String getName() {
        return this.name;
    }
    private void setName(String value) {
        this.name = value;
    }
    @Override
    public FragmentType getType() {
        return this.type;
    }
    protected void setType(FragmentType value) {
        this.type = value;
    }
    @Override
    public Integer getPressureAffection() {
        return this.pressureAffection;
    }
    protected void setPressureAffection (Integer value) {
        if(value<=0){
            throw  new IllegalArgumentException();
        }
        this.pressureAffection = value;
    }


}
