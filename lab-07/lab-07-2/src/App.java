import java.util.List;
import java.util.ArrayList;

interface Observer {
    void updateDoorOpen(Door door);

    void updateDoorClose(Door door);
}

class Door {
    private boolean isOpen = false;
    private String name;

    public Door(String name) {
        this.name = name;
    }

    public void open() {
        this.isOpen = true;
        System.out.println("Door " + this.name + " opened");
    }

    public void close() {
        this.isOpen = false;
        System.out.println("Door " + this.name + " closed");
    }

}

class ControlCenter implements Observer {
    private List<Door> doors;

    public ControlCenter() {
        this.doors = new ArrayList<Door>();
    }

    public void registerObserver(Door door) {
        this.doors.add(door);
    }

    public void openAllDoors() {
        for (Door door : this.doors) {
            door.open();
        }
    }

    public void closeAllDoors() {
        for (Door door : this.doors) {
            door.close();
        }
    }

    @Override
    public void updateDoorOpen(Door door) {
        door.open();
    }

    @Override
    public void updateDoorClose(Door door) {
        door.close();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Create Door objects
        Door D1 = new Door("D1");
        Door D2 = new Door("D2");
        Door D3 = new Door("D3");

        // Create a ControlCenter object
        ControlCenter controlCenter = new ControlCenter();

        // Register doors with the control center
        controlCenter.registerObserver(D1);
        controlCenter.registerObserver(D2);
        controlCenter.registerObserver(D3);

        // Manually open and close doors
        D1.open();
        D2.open();
        D1.close();

        // Use the control center to open and close all doors
        controlCenter.openAllDoors();
        controlCenter.closeAllDoors();

        // Add a new door and register it with the control center
        Door D4 = new Door("D4");
        controlCenter.registerObserver(D4);
        controlCenter.openAllDoors();
    }
}
