package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {
    private Assembler assembler;
    private AttackModifyingPart attackModifyingPart1;
    private DefenseModifyingPart defenseModifyingPart1;
    private HitPointsModifyingPart hitPointsModifyingPart1;


    @Before
    public void setUp() throws Exception {
        this.assembler=new VehicleAssembler();
        this.attackModifyingPart1=Mockito.mock(AttackModifyingPart .class);
        this.defenseModifyingPart1 =Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart1 =Mockito.mock(HitPointsModifyingPart.class);

        this.assembler.addArsenalPart(this.attackModifyingPart1);
        this.assembler.addShellPart(this.defenseModifyingPart1);
        this.assembler.addEndurancePart(this.hitPointsModifyingPart1);
    }

    @Test
    public void getTotalWeight() {
        //Arrange
        Mockito.when(this.attackModifyingPart1.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart1.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart1.getWeight()).thenReturn(30.0);
        //Act
        double actualTotalWeight = this.assembler.getTotalWeight();
        double expectedTotalWeight = 60;
        //Assert
        Assert.assertEquals(actualTotalWeight, expectedTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {

        //Arrange
        Mockito.when(this.attackModifyingPart1.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.defenseModifyingPart1.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.hitPointsModifyingPart1.getPrice()).thenReturn(BigDecimal.TEN);

        //Act
        BigDecimal totalPrice = this.assembler.getTotalPrice();
        BigDecimal resExpected=BigDecimal.valueOf(30);

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
    public void getTotalAttackModification() {
        //Arrange
        Mockito.when(this.attackModifyingPart1.getAttackModifier()).thenReturn(50);

        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(120);
        this.assembler.addArsenalPart(attackModifyingPart);
        //Act
        long totalAttackModification = this.assembler.getTotalAttackModification();
        long expectedAttackModification = 170;

        //Assert
        Assert.assertEquals(expectedAttackModification,totalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        //Arrange
        Mockito.when(this.defenseModifyingPart1.getDefenseModifier()).thenReturn(50);

        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(120);
        this.assembler.addShellPart(defenseModifyingPart);
        //Act
        long totalDefenseModification = this.assembler.getTotalDefenseModification();
        long expectedDefenseModification = 170;

        //Assert
        Assert.assertEquals(expectedDefenseModification,totalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        //Arrange
        Mockito.when(this.hitPointsModifyingPart1.getHitPointsModifier()).thenReturn(50);

        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(120);
        this.assembler.addEndurancePart(hitPointsModifyingPart);
        //Act
        long totalHitPointsModification = this.assembler.getTotalHitPointModification();
        long expectedHitPointsModification = 170;

        //Assert
        Assert.assertEquals(expectedHitPointsModification,totalHitPointsModification);
    }

    @Test
    public void addArsenalPartSize() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        AttackModifyingPart attackModifyingPart1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart attackModifyingPart2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart attackModifyingPart3 = Mockito.mock(AttackModifyingPart.class);

        //Act
        assembler.addArsenalPart(attackModifyingPart1);
        assembler.addArsenalPart(attackModifyingPart2);
        assembler.addArsenalPart(attackModifyingPart3);

        int size=0;
        try {
            Field fieldArsenal = assembler.getClass().getDeclaredField("arsenalParts");
            fieldArsenal.setAccessible(true);
            List<AttackModifyingPart>list= (List<AttackModifyingPart>) fieldArsenal.get(assembler);
            size=list.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //Assert
        Assert.assertEquals(size,3);
    }
    @Test
    public void addArsenalPartSum() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        AttackModifyingPart attackModifyingPart1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart attackModifyingPart2 = Mockito.mock(AttackModifyingPart.class);

        Mockito.when(attackModifyingPart1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(attackModifyingPart2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        //Act
        assembler.addArsenalPart(attackModifyingPart1);
        assembler.addArsenalPart(attackModifyingPart2);

        long totalAttackModification = assembler.getTotalAttackModification();


        //Assert
        Assert.assertEquals(2L*Integer.MAX_VALUE,totalAttackModification);
    }


    @Test
    public void addShellPartSize() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        DefenseModifyingPart attackModifyingPart1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart attackModifyingPart2 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart attackModifyingPart3 = Mockito.mock(DefenseModifyingPart.class);

        //Act
        assembler.addShellPart(attackModifyingPart1);
        assembler.addShellPart(attackModifyingPart2);
        assembler.addShellPart(attackModifyingPart3);

        int size=0;
        try {
            Field fieldArsenal = assembler.getClass().getDeclaredFields()[1];
            fieldArsenal.setAccessible(true);
            List<DefenseModifyingPart>list= (List<DefenseModifyingPart>) fieldArsenal.get(assembler);
            size=list.size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //Assert
        Assert.assertEquals(size,3);
    }
    @Test
    public void addShellPartSum() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        DefenseModifyingPart attackModifyingPart1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart attackModifyingPart2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(attackModifyingPart1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(attackModifyingPart2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        //Act
        assembler.addShellPart(attackModifyingPart1);
        assembler.addShellPart(attackModifyingPart2);



        //Assert
        Assert.assertEquals(2L*Integer.MAX_VALUE,assembler.getTotalDefenseModification());
    }

    @Test
    public void addEndurancePartSize() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        HitPointsModifyingPart attackModifyingPart1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart attackModifyingPart2 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart attackModifyingPart3 = Mockito.mock(HitPointsModifyingPart.class);

        //Act
        assembler.addEndurancePart(attackModifyingPart1);
        assembler.addEndurancePart(attackModifyingPart2);
        assembler.addEndurancePart(attackModifyingPart3);

        int size=0;
        try {
            Field fieldArsenal = assembler.getClass().getDeclaredFields()[2];
            fieldArsenal.setAccessible(true);
            List<HitPointsModifyingPart>list= (List<HitPointsModifyingPart>) fieldArsenal.get(assembler);
            size=list.size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //Assert
        Assert.assertEquals(size,3);
    }
    @Test
    public void addEndurancePartSum() {
        //Arrange
        Assembler assembler=new VehicleAssembler();
        HitPointsModifyingPart attackModifyingPart1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart attackModifyingPart2 = Mockito.mock(HitPointsModifyingPart.class);

        Mockito.when(attackModifyingPart1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(attackModifyingPart2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);


        //Act
        assembler.addEndurancePart(attackModifyingPart1);
        assembler.addEndurancePart(attackModifyingPart2);


        //Assert
        Assert.assertEquals(2L*Integer.MAX_VALUE,assembler.getTotalHitPointModification());
    }
}