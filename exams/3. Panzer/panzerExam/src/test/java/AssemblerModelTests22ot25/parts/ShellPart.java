package AssemblerModelTests22ot25.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends AbstractPart implements DefenseModifyingPart {
    private  int defenseModifier;

    public ShellPart(String name, double weight, BigDecimal price, int defenseModifier) {
        super(name, weight, price);
        this.defenseModifier = defenseModifier;
    }


    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(String.format("+%d Defense",this.defenseModifier));
        return res.toString();
    }
}
