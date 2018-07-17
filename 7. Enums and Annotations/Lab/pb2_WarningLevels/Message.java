package pb2_WarningLevels;

public class Message {
    private Importance level;
    private String message;

    public Message(Importance level, String message) {
        this.level = level;
        this.message = message;
    }

    public Importance getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.level.toString()+": "+this.message;
    }
}
