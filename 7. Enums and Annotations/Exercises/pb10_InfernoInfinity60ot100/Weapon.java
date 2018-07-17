package pb10_InfernoInfinity60ot100;

public  enum  Weapon {
    AXE(5,10,new Gem[4]),
    SWORD(4,6,new Gem[3]),
    KNIFE(3,4,new Gem[2]);

    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;

    Weapon( int minDamage, int maxDamage, Gem[] sockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = sockets;
    }
    public void addGem(int index, Gem gem){
        if(index>=0&&index<this.sockets.length){
            this.sockets[index]=gem;
        }
    }

    public void removeGem(int index) {
        if(index>=0&&index<this.sockets.length){
            this.sockets[index]=null;
        }
    }
    private int[] calculateStats(){
        int[] res=new int[5];
        int minDam=this.minDamage;
        int maxDam=this.maxDamage;
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
        int[] res=this.calculateStats();
        return String.format("%d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                res[0],res[1],res[2],res[3],res[4]);
    }
}
