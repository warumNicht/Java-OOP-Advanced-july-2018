package AssemblerModelTests22ot25;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;
import panzer.models.miscellaneous.VehicleAssembler;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class AssemblerTests {
    private static final double MAX_FLOATING_POINT_NUMBER=10;
    private static final int MAX_INT_NUMBER=Integer.MAX_VALUE;

    private AttackModifyingPart attackModifyingPart1;
    private AttackModifyingPart attackModifyingPart2;
    private DefenseModifyingPart defenseModifyingPart1;
    private DefenseModifyingPart defenseModifyingPart2;
    private HitPointsModifyingPart hitPointsModifyingPart1;
    private HitPointsModifyingPart hitPointsModifyingPart2;

    private Assembler assembler;

    @Before
    public void initializeTestingObjects(){
        this.assembler=new VehicleAssembler();

        this.attackModifyingPart1 =Mockito.mock(AttackModifyingPart.class);
        this.attackModifyingPart2 =Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart1 =Mockito.mock(DefenseModifyingPart.class);
        this.defenseModifyingPart2 =Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart1 =Mockito.mock(HitPointsModifyingPart.class);
        this.hitPointsModifyingPart2 =Mockito.mock(HitPointsModifyingPart.class);

        this.assembler.addArsenalPart(this.attackModifyingPart1);
        this.assembler.addShellPart(this.defenseModifyingPart1);
        this.assembler.addEndurancePart(this.hitPointsModifyingPart1);


    }


    @Test
    public void testTotalWeight(){
        //Arrange
        Mockito.when(this.attackModifyingPart1.getWeight()).thenReturn(20.0);
        Mockito.when(this.defenseModifyingPart1.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart1.getWeight()).thenReturn(30.0);
        //Act
        double actualTotalWeight = this.assembler.getTotalWeight();
        double expectedTotalWeight = 70;
        //Assert
        Assert.assertEquals(actualTotalWeight, expectedTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {

        //Arrange
        Mockito.when(this.attackModifyingPart1.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.defenseModifyingPart1.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.hitPointsModifyingPart1.getPrice()).thenReturn(BigDecimal.TEN);

        //Act
        BigDecimal totalPrice = this.assembler.getTotalPrice();
        BigDecimal resExpected=BigDecimal.valueOf(21);

        //Assert
        Assert.assertEquals(resExpected, totalPrice);
    }
    @Test
    public void getTotalPriceFromEmptyCollection() {
        //Arrange
        Assembler assembler=new VehicleAssembler();

        //Act
        BigDecimal totalPrice = assembler.getTotalPrice();
        BigDecimal resExpected=BigDecimal.ZERO;

        //Assert
        Assert.assertEquals(resExpected, totalPrice);
    }
    @Test
    public void addingArsenalParts()  {
        Assembler assembler=new VehicleAssembler();
        Mockito.when(this.attackModifyingPart1.getAttackModifier()).thenReturn(MAX_INT_NUMBER);
        Mockito.when(this.attackModifyingPart2.getAttackModifier()).thenReturn(MAX_INT_NUMBER);

        assembler.addArsenalPart(this.attackModifyingPart1);
        assembler.addArsenalPart(this.attackModifyingPart2);

        long res=assembler.getTotalAttackModification();

        Class assemlClass=VehicleAssembler.class;
        Field arsenalField=assemlClass.getDeclaredFields()[0];
        arsenalField.setAccessible(true);

        int arsSize= 0;
        try {
            arsSize = ((List<AttackModifyingPart>)arsenalField.get(assembler)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,arsSize);
        Assert.assertEquals(res,2L*MAX_INT_NUMBER);
    }

    @Test
    public void addingShellParts()  {
        Assembler assembler=new VehicleAssembler();

        Mockito.when(this.defenseModifyingPart1.getDefenseModifier()).thenReturn(MAX_INT_NUMBER);
        Mockito.when(this.defenseModifyingPart2.getDefenseModifier()).thenReturn(MAX_INT_NUMBER);

        assembler.addShellPart(this.defenseModifyingPart1);
        assembler.addShellPart(this.defenseModifyingPart2);

        long res=assembler.getTotalDefenseModification();

        Class assemlClass=VehicleAssembler.class;
        Field arsenalField=assemlClass.getDeclaredFields()[1];
        arsenalField.setAccessible(true);

        int arsSize= 0;
        try {
            arsSize = ((List<AttackModifyingPart>)arsenalField.get(assembler)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,arsSize);

        Assert.assertEquals(res,2L*MAX_INT_NUMBER);
    }
    @Test
    public void addingEnduranceParts()  {
        Assembler assembler=new VehicleAssembler();

        Mockito.when(this.hitPointsModifyingPart1.getHitPointsModifier()).thenReturn(MAX_INT_NUMBER);
        Mockito.when(this.hitPointsModifyingPart2.getHitPointsModifier()).thenReturn(MAX_INT_NUMBER);


        assembler.addEndurancePart(this.hitPointsModifyingPart1);
        assembler.addEndurancePart(this.hitPointsModifyingPart2);

        long res=assembler.getTotalHitPointModification();

        Field arsenalField=assembler.getClass().getDeclaredFields()[2];
        arsenalField.setAccessible(true);

        int arsSize= 0;
        try {
            arsSize = ((List<AttackModifyingPart>)arsenalField.get(assembler)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,arsSize);

        Assert.assertEquals(res,2L*MAX_INT_NUMBER);
    }
}
