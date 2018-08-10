package panzer.models.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends AbstractPart implements HitPointsModifyingPart {
    private int hitPointsModifier;


    public EndurancePart(String name, double weight, BigDecimal price, int hitPointsModifier) {
        super(name, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(String.format("+%d HitPoints",this.hitPointsModifier));
        return res.toString();
    }
}
