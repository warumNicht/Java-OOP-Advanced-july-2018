package pb6_MirrorImage;

import java.util.HashMap;
import java.util.Map;

public class WizardImpl implements Wizard{
    private static int counter;
    private static String name;
    private static Map<Integer,Wizard> wizards;
    private int id;
    private int magicalPower;
    private Wizard successor1;
    private Wizard successor2;

    public WizardImpl(String name,int magicalPower) {
        this.id=counter;
        WizardImpl.name = name;
        this.magicalPower=magicalPower;
        wizards=new HashMap<>();
        wizards.put(0,this);
        counter++;
    }
    public WizardImpl() {
        this.id=counter;
        counter++;
    }
    @Override
    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }

    private   Wizard findById(int id){
        if(wizards.containsKey(id)){
            return wizards.get(id);
        }
        return null;
    }

    @Override
    public  void castReflection(){
        System.out.println(String.format("%s %d casts Reflection",name,this.id));
        if(this.successor1==null){
            Wizard wizard=new WizardImpl();
            wizard.setMagicalPower(this.magicalPower/2);
            this.successor1=wizard;
            wizards.put(wizard.getId(),wizard);
        }else {
            this.successor1.castReflection();
        }
        if(this.successor2==null){
            Wizard wizard=new WizardImpl();
            wizard.setMagicalPower(this.magicalPower/2);
            this.successor2=wizard;
            wizards.put(wizard.getId(),wizard);
        }else {
            this.successor2.castReflection();
        }
    }

    @Override
    public void castFireball(){
        System.out.println(String.format("%s %d casts Fireball for %d damage",name,this.id,this.magicalPower));
        if(this.successor1!=null){
            this.successor1.castFireball();
        }
        if(this.successor2!=null){
            this.successor2.castFireball();
        }
    }
    @Override
    public void castFireball(int id){
        Wizard wizard=this.findById(id);
        if(wizard!=null)
            wizard.castFireball();
    }


    @Override
    public  void castReflection(int id){
        Wizard wizard=this.findById(id);
        if(wizard!=null)
        wizard.castReflection();
    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
