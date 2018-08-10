package softuni.models.entities.fragments;


import softuni.models.enums.FragmentType;

public class CoolingFragment extends BaseFragment {
    public CoolingFragment(String name, Integer pressureAffection) {
        super(name);
        super.setPressureAffection(pressureAffection * 3);
        super.setType(FragmentType.Cooling);
    }

    @Override
    public Integer getPressureAffection() {
        return -super.getPressureAffection();
    }
}
