package pb8_PetClinics;

import java.util.Iterator;

public class Clinic {
    private String name;
    private Pet[] rooms;

    public Clinic(String name,int n) {
        this.name = name;
        this.setRooms(n);
    }

    private void setRooms(int n) {
        if(n%2==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[n];
    }

    public  boolean addPetByIterator(Pet pet){
        AddRoomsIterator roomsIterator=new AddRoomsIterator();

        while (roomsIterator.hasNext()){
            Pet curPet=roomsIterator.next();
            if(curPet==null){
                this.rooms[roomsIterator.curPosition]=pet;
                return true;
            }
        }
        return false;
    }

    public boolean releaseIterator(){

        ReleaseIterator releaseIter=new ReleaseIterator();

        while (releaseIter.hasNext()){
            if(releaseIter.next()!=null){
                this.rooms[releaseIter.currentPosition]=null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRoom(){
        for (Pet room : rooms) {
            if(room==null){
                return true;
            }
        }
        return false;
    }
    public  void print(){
        for (Pet room : rooms) {
            if(room==null){
                System.out.println("Room empty");
            }else {
                System.out.println(room.toString());
            }
        }
    }
    public  void print(int n){

        if(this.rooms[n-1]==null){
            System.out.println("Room empty");
        }else {
            System.out.println(this.rooms[n-1].toString());
        }
    }


    public String getName() {
        return name;
    }

    public Pet[] getRooms() {
        return rooms;
    }

    private final class AddRoomsIterator implements Iterator<Pet> {
        private int counter;
        private int central;
        private int pairs;
        private int curPosition;

        public AddRoomsIterator() {
            counter=0;
            central=rooms.length/2;
            pairs=1;
            curPosition=0;
        }

        @Override
        public boolean hasNext() {
            return counter<rooms.length;
        }

        @Override
        public Pet next() {
            counter++;

            if(counter==1){
                curPosition=central;
                return rooms[central];
            }
            if(counter%2==0){
                curPosition=central-pairs;
                return rooms[central-pairs];
            }
            curPosition=central+pairs;
            pairs++;
            return rooms[central+pairs-1];
        }
    }
    private final class ReleaseIterator implements Iterator<Pet>{
        private int counter;
        private int center;
        private int currentPosition;

        public ReleaseIterator() {
            this.counter=0;
            this.center=rooms.length/2;
            this.currentPosition=0;
        }

        @Override
        public boolean hasNext() {
            if(counter<rooms.length){
                return true;
            }
            return false;
        }

        @Override
        public Pet next() {
            counter++;
            if(counter==1){
                currentPosition=center;
                return rooms[center];
            }
            if(counter<=center){
                currentPosition=center+counter-1;
                return rooms[currentPosition];
            }
            currentPosition=counter-center-1;
            return rooms[currentPosition];
        }
    }
}
