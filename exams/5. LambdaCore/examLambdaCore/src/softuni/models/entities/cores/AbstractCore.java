package softuni.models.entities.cores;

import softuni.interfaces.Fragment;
import softuni.models.collection.LStack;
import softuni.models.enums.StatusType;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCore {
    private static char FIRST_LETTER='A';

    private String name;
    private Integer durability;
    private LStack listStack;
    private StatusType statusType;
    private List<Fragment> listFragments;

    protected AbstractCore(Integer durability) {
        this.setDurability(durability);
        this.name = ""+FIRST_LETTER;
        FIRST_LETTER++;
        this.listStack =new LStack();
        this.statusType=StatusType.NORMAL;
        this.listFragments=new ArrayList<>();
    }

    protected void setDurability(Integer durability) {
        if(durability<=0){
            throw new IllegalArgumentException("Failed to create Core!");
        }
        this.durability = durability;
    }

    public String getName() {
        return name;
    }
    public void addFragment(Fragment fragment){
        this.listStack.push(fragment);
        this.listFragments.add(fragment);
        this.checkCore();

    }
    private  void checkCore(){
        int corePress=this.getAllPressure();
        if(corePress>0){
            this.statusType=StatusType.CRITICAL;
        }else {
            this.statusType=StatusType.NORMAL;
        }
    }
    public int  checkDurabulity(){
        int corePress=this.getAllPressure();
        if(corePress>0){
            if(this.durability>corePress){
                return this.durability-corePress;
            }else {
                this.listStack.pop();
            }
        }
        return this.durability;

    }

    public LStack getListStack() {
        return listStack;
    }

    private   int getAllPressure(){
        int res=0;
        int size=this.listStack.size();
        for (Fragment fragment : listFragments) {
            res+=fragment.getPressureAffection();
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Core %s:",this.name))
                .append(System.lineSeparator())
                .append(String.format("####Durability: %d", this.checkDurabulity()))
                .append(System.lineSeparator())
                .append(String.format("####Status: %s",this.statusType.name()));

        return res.toString();
    }
}
