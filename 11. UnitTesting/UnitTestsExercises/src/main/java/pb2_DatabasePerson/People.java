package pb2_DatabasePerson;

public class People implements Comparable<People>{
    private String userName;
    private long id;

    public People(String userName, long id) {
        this.userName = userName;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public int compareTo(People o) {
        if(this.getUserName().compareTo(o.getUserName())==0){
            return Long.compare(this.getId(),o.getId());
        }
        return this.getUserName().compareTo(o.getUserName());
    }
}
