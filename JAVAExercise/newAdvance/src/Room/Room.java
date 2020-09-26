package Room;

public class Room {

    private int number;
    private String type;
    private boolean live;

    public Room(int number, int index, boolean live) {
        String[] type = {"普通","标准","豪华"};
        this.number = number;
        this.type = type[index];
        this.live = live;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
