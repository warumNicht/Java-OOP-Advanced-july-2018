package pb10_InfernoInfinity60ot100;

import java.util.LinkedHashMap;

public class WeaponManager {
    private LinkedHashMap<String,Weapon> weapons;

    public WeaponManager() {
        this.weapons=new LinkedHashMap<>();
    }
    public void createWeapon(String name, Weapon weapon){
        this.weapons.put(name,weapon);
    }
    public void addGem(String weaponName,int index,Gem gem ){
        if(this.weapons.containsKey(weaponName)){
            Weapon curWeapon=this.weapons.get(weaponName);
            curWeapon.addGem(index,gem);
        }
    }
    public void removeGem(String weaponName,int index){
        if(this.weapons.containsKey(weaponName)){
            Weapon curWeapon=this.weapons.get(weaponName);
            curWeapon.removeGem(index);
        }
    }
    public void print(String weaponName){
        if(this.weapons.containsKey(weaponName)){
            Weapon curWeapon=this.weapons.get(weaponName);
            System.out.println(String.format("%s: %s",weaponName,curWeapon.toString()));
        }
    }

}
