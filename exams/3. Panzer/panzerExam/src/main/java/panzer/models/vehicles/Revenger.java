package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends AbstractVehicle {
    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight,
                price ,
                attack+(attack*150)/100,
                defense -(defense*50)/100,
                hitPoints-(hitPoints*50)/100);
        super.setPrice(this.increasePrice(price));
    }
    private BigDecimal increasePrice(BigDecimal price){
        BigDecimal fifty=new BigDecimal("1.5");
        return price.multiply(fifty);
    }
}
