import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    // main attributes
    private Integer roomID;
    private String description;
    private HashMap<String, Integer> exits;
    private ArrayList<Integer> lockedExits;
    private boolean visited;

    // Object attributes addon
    private ArrayList<Item> items;
    private Puzzle puzzle;
    private ArrayList<Monster> monsters;


    // instantiate
    public Room() {
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.lockedExits = new ArrayList<>();
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Integer> getExits() {
        return exits;
    }

    public void setExits(HashMap<String, Integer> exits) {
        this.exits = exits;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItems(Item items) {
        this.items.add(items);
    }


    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public boolean getVisited() {
        return this.visited;
    }

    // only set to visited ONCE the player LEAVE the room or just right before they leave the room
    public void setVisited(boolean aVisited) {
        this.visited = aVisited;
    }

    // returns the room object in a string format
    public String toString() {
        String roomNumber = "room ID: " + this.roomID + "\n";
        String desc = "Description: " + this.description + "\n";


        String visited = "[New Room] \n\n";
        StringBuilder monster = new StringBuilder();
        StringBuilder items = new StringBuilder();
        String puzzle = "";

        if (getVisited()) {
            visited = "[[You have visited this room before]] \n\n";
        }

        if (!this.monsters.isEmpty()) {
            monster = new StringBuilder("[monster(s)]: \n");
            for (Monster m : this.monsters) {
                monster.append(m.getName()).append("\n\n");
            }
        }

        if (this.puzzle != null) {
            puzzle = "[puzzle]: \n" + this.puzzle + "\n";
        }

        if (!this.items.isEmpty()) {
            items = new StringBuilder("[item(s)]: \n");
            for (Item i : this.items) {
                items.append(i.getName()).append("\n\n");
            }
        }

        return roomNumber + desc + visited + monster + puzzle + items + exits.toString();
    }

    public String itemsToString() {
        if (!items.isEmpty()) {
            StringBuilder items = new StringBuilder("[item(s)]: \n");
            int count = 1;
            for (Item i : this.items) {
                items.append(count).append(". ").append(i.getName()).append("\n\n");
                count += 1;
            }

            return items.toString();
        } else {
            return "no [items] found in the room";
        }
    }

    public ArrayList<Integer> getLockedExits() {
        return lockedExits;
    }

    public void setLockedExits(ArrayList<Integer> lockedExits) {
        this.lockedExits = lockedExits;
    }

    // checks if it is a valid exit and room that a user can go to
    public boolean checkDirection(String direction) {
        return exits.containsKey(direction);
    }

    // check if the room is locked
    public boolean checkLocked(String direction) {
        return lockedExits.contains(exits.get(direction));
    }
}