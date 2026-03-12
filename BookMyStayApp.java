/**

 * Book My Stay App - Use Case 3
 *
 * Demonstrates centralized room inventory management using HashMap.
 * Version: 3.1
 *
 * Author: Your Name
 */

import java.util.HashMap;
import java.util.Map;

// Abstract Room class
abstract class Room {
    protected String type;
    protected int beds;
    protected double price;
    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price per night: $" + price);
    }

}

// Concrete room classes
class SingleRoom extends Room {
    public SingleRoom() { super("Single Room", 1, 50.0); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double Room", 2, 90.0); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite Room", 3, 150.0); }
}

// Inventory class
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room type with availability
    public void addRoom(Room room, int available) {
        inventory.put(room.getType(), available);
    }

    // Get availability for a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability for a room type
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        }
    }

    // Display current inventory
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - Available: " + entry.getValue());
        }
    }

}

// Main application
public class UseCase3InventorySetup {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App - Version 3.1");

        // Initialize rooms
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(single, 5);
        inventory.addRoom(doubleRoom, 3);
        inventory.addRoom(suite, 2);

        // Display room details
        single.displayDetails();
        doubleRoom.displayDetails();
        suite.displayDetails();

        // Display centralized inventory
        inventory.displayInventory();

        // Example update
        inventory.updateAvailability("Single Room", 4);
        System.out.println("\nAfter booking 1 Single Room:");
        inventory.displayInventory();
    }


}
