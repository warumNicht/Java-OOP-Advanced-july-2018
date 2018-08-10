package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends AbstractVehicle {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight*2, price,
                attack-(attack*25)/100,
                defense +(defense*50)/100,
                hitPoints+(hitPoints*75)/100);
    }
}
