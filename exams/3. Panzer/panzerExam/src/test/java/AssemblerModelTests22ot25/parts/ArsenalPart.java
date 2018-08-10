package AssemblerModelTests22ot25.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends AbstractPart implements AttackModifyingPart {
    private int attackModifier;


    public ArsenalPart(String name, double weight, BigDecimal price, int attackModifier) {
        super(name, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(String.format("+%d Attack",this.attackModifier));
        return res.toString();
    }
}
