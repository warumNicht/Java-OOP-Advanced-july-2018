package softuni.models.entities.fragments;


import softuni.models.enums.FragmentType;

public class NuclearFragment extends BaseFragment{

    public NuclearFragment(String name, Integer pressureAffection) {
        super(name);
        super.setPressureAffection(pressureAffection*2);
        super.setType(FragmentType.Nuclear);
    }


}
