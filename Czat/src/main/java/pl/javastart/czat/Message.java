package pl.javastart.czat;

public class Message {
    private String sender;
    private String content;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    @Override
    public String toString() {
        return  sender + ": " + content;
    }
}
