package moduleContainerTests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ModuleContainerTests {
    private AbsorbingModule absorberModule1;
    private AbsorbingModule absorberModule2;
    private EnergyModule energyModule1;
    private EnergyModule energyModule2;
    private Container container;

    @Before
    public void before(){
        this.absorberModule1=Mockito.mock(AbsorbingModule.class);
        this.absorberModule2=Mockito.mock(AbsorbingModule.class);
        this.energyModule1=Mockito.mock(EnergyModule.class);
        this.energyModule2=Mockito.mock(EnergyModule.class);
        this.container=new ModuleContainer(3);

        Mockito.when(absorberModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(absorberModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);

        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);

        Mockito.when(absorberModule1.getId()).thenReturn(1);
        Mockito.when(absorberModule2.getId()).thenReturn(2);
        Mockito.when(energyModule1.getId()).thenReturn(3);
        Mockito.when(energyModule2.getId()).thenReturn(4);

    }
    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleException(){
        this.container.addEnergyModule(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleException(){
        this.container.addAbsorbingModule(null);
    }
    @Test
    public void removeModule(){
        this.container.addAbsorbingModule(this.absorberModule1);
        this.container.addAbsorbingModule(this.absorberModule2);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(),2_000_000_000L);
        Assert.assertEquals(this.container.getTotalEnergyOutput(),4_000_000_000L);
    }

    @Test
    public void absorbingModuleWorksWithLong(){
        this.container.addAbsorbingModule(this.absorberModule1);
        this.container.addAbsorbingModule(this.absorberModule2);

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(),4_000_000_000L);
    }

    @Test
    public void emptyModuleRetursZero(){

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(),0);
        Assert.assertEquals(this.container.getTotalEnergyOutput(),0);
    }

    @Test
    public void borderCaseCount(){
        this.container.addAbsorbingModule(this.absorberModule2);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(),2_000_000_000L);
        Assert.assertEquals(this.container.getTotalEnergyOutput(),4_000_000_000L);
    }
}
