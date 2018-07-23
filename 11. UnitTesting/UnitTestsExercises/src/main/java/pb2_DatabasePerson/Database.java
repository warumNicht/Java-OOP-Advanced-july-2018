package pb2_DatabasePerson;

import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int CAPACITY = 16;
    private  People[] elements;
    private int index;

    public Database(int count) throws OperationNotSupportedException {
        this.setElements(count);
        this.index=0;
    }

    private void setElements(int count) throws OperationNotSupportedException {
        if(count!=CAPACITY){
            throw new OperationNotSupportedException();
        }
        this.elements = new People[count];
    }

    public void add(People element) throws OperationNotSupportedException {
        if(element==null||this.index==CAPACITY){
            throw new OperationNotSupportedException();
        }

        for (People people : elements) {
            if(people!=null&&(people.getId()==element.getId()||people.getUserName().equals(element.getUserName()))){
                throw new OperationNotSupportedException();
            }
        }

        this.elements[index]=element;
        ++this.index;
    }
    public People remove() throws OperationNotSupportedException {
        if(this.index<=0||this.elements[this.index-1]==null){
            throw new OperationNotSupportedException();
        }

        People res=this.elements[--this.index];
        return res;
    }
    public People[] fetch(){
        People[] res=new People[this.index+1];

        if(this.elements[0]!=null){
            for(int i=0; i<this.index; i++){
                res[i]=this.elements[i];
            }
            return res;
        }
        return null;
    }
    public People findById(long id) throws OperationNotSupportedException {
        People wanted=null;
        for (People element : elements) {
            if(element!=null&&element.getId()==id){
                wanted=element;
            }
        }
        if(wanted==null){
            throw new OperationNotSupportedException();
        }
        return wanted;
    }

    public People findByUserName(String userName) throws OperationNotSupportedException {
        if(userName==null){
            throw new OperationNotSupportedException();
        }
        People wanted=null;
        for (People element : elements) {
            if(element!=null&&userName.equals(element.getUserName())){
                wanted=element;
            }
        }
        if(wanted==null){
            throw new OperationNotSupportedException();
        }
        return wanted;
    }
}
