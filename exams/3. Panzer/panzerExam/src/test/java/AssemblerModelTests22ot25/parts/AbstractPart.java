package AssemblerModelTests22ot25.parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class AbstractPart implements Part {
    private String name;
    private  double weight;
    private BigDecimal price;

    protected AbstractPart(String name, double weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s Part - %s%n",this.getClass().getSimpleName().replace("Part",""),this.name);
    }
}
