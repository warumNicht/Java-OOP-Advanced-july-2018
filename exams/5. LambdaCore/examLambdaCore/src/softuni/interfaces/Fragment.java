package softuni.interfaces;

import softuni.models.enums.FragmentType;

public interface Fragment {
    String getName();

    FragmentType getType();

    Integer getPressureAffection();
}
