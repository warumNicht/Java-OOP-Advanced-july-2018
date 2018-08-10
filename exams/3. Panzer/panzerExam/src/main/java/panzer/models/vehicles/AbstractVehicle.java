package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractVehicle implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;

    protected AbstractVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler=new VehicleAssembler();
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public double getTotalWeight() {
        return this.weight+this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack+this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense+this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints+this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        Class assemblerClass=VehicleAssembler.class;
        Field listAllParts=assemblerClass.getDeclaredFields()[3];
        listAllParts.setAccessible(true);
        try {
            List<Part> allParts=(List<Part>) listAllParts.get(this.assembler);
            return allParts;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {

        StringBuilder res=new StringBuilder();
        res.append(String.format("%s - %s",this.getClass().getSimpleName(),this.model))
        .append(System.lineSeparator())
                .append(String.format("Total Weight: %.3f",this.getTotalWeight()))
                .append(System.lineSeparator())
                .append(String.format("Total Price: %.3f",this.getTotalPrice()))
                .append(System.lineSeparator())
                .append(String.format("Attack: %d",this.getTotalAttack()))
                .append(System.lineSeparator())
                .append(String.format("Defense: %d",this.getTotalDefense()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d",this.getTotalHitPoints()))
                .append(System.lineSeparator());

        List<String> partsModels=new ArrayList<>();
        for (Part part : this.getParts()) {
            partsModels.add(part.getModel());
        }

        res.append(String.format("Parts: %s", partsModels.isEmpty() ? "None" : String.join(", ", partsModels)));

        return res.toString();
    }
}
