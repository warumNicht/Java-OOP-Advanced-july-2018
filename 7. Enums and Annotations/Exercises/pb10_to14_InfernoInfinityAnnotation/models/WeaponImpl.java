package pb10_to14_InfernoInfinityAnnotation.models;

import pb10_to14_InfernoInfinityAnnotation.CustomAnnotation;
import pb10_to14_InfernoInfinityAnnotation.enums.Gem;
import pb10_to14_InfernoInfinityAnnotation.enums.WeaponType;
import pb10_to14_InfernoInfinityAnnotation.interfaces.Weapon;

@CustomAnnotation(author = "Pesho",revision = 3,description ="Used for Java OOP Advanced course - Enumerations and Annotations.",
reviewers = {"Pesho", "Svetlio"})
public class WeaponImpl implements Weapon,Comparable<Weapon> {
    private String name;
    private WeaponType type;
    private Gem[] sockets;

    public WeaponImpl(String name, WeaponType type) {
        this.name = name;
        this.type = type;
        this.sockets=new Gem[this.type.getNumberOfSockets()];
    }

    @Override
    public void addGem(Gem gem, int index) {
        if(index>=0&&index<this.sockets.length){
            this.sockets[index]=gem;
        }

    }

    @Override
    public void removeGem(int index) {
        if(index>=0&&index<this.sockets.length){
            this.sockets[index]=null;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    private int getAllStrength(){
        int strength=0;
        for (Gem socket : sockets) {
            if(socket!=null){
                strength+=socket.getStrength();
            }
        }
        return strength;
    }
    private int getAllAgility(){
        int agility=0;
        for (Gem socket : sockets) {
            if(socket!=null){
                agility+=socket.getAgility();
            }
        }
        return agility;
    }
    private int getMinDamage(){
        int minDamage=this.type.getMinDamage();
        minDamage+=2*this.getAllStrength();
        minDamage+=this.getAllAgility();
        return minDamage;
    }
    private int getMaxDamage(){
        int maxDamage=this.type.getMaxDamage();
        maxDamage+=3*this.getAllStrength();
        maxDamage+=4*this.getAllAgility();
        return maxDamage;
    }

    private int[] calculateStats(){
        int[] res=new int[5];
        int minDam=this.type.getMinDamage();
        int maxDam=this.type.getMaxDamage();
        int strength=0;
        int agility=0;
        int vitality=0;

        for (Gem socket : sockets) {
            if(socket!=null){
                minDam+=socket.getStrength()*2+socket.getAgility();
                maxDam+=socket.getStrength()*3+socket.getAgility()*4;

                strength+=socket.getStrength();
                agility+=socket.getAgility();
                vitality+=socket.getVitality();
            }
        }
        res[0]=minDam;
        res[1]=maxDam;
        res[2]=strength;
        res[3]=agility;
        res[4]=vitality;

        return res;
    }
    @Override
    public String toString() {
        int res[]=this.calculateStats();

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,
                res[0],
                res[1],
                res[2],
                res[3],
                res[4]);
    }

    private int getAllVitality() {
        int agility=0;
        for (Gem socket : sockets) {
            if(socket!=null){
                agility+=socket.getVitality();
            }
        }
        return agility;
    }
    public double getLevel(){
        double res=(this.getMinDamage()+this.getMaxDamage())/2.0;

        return res+this.getAllStrength()+this.getAllVitality()+this.getAllAgility();
    }

    @Override
    public int compareTo(Weapon o) {
        if(this.getLevel()>=o.getLevel()){
            return 1;
        }
        return -1;
    }

    @Override
    public void print() {
        System.out.println(String.format("%s (Item Level: %.1f)",this.toString(),this.getLevel()));
    }
}
