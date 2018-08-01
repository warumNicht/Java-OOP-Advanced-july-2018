package pb1_EventImplementation.events;

public class NameChange extends Event {
    private String changedName;

    public NameChange(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedName() {
        return changedName;
    }
}
