import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private String description;
    private int currentRoom = 0;
    private ArrayList<Item> inventory;
    private Item equipedItem;
    private double avoidChance = .75;

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int aHealth) {
        this.health = aHealth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public int getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(int aCurrentRoom) {
        this.currentRoom = aCurrentRoom;
    }

    public Object getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<Item> aInventory) {
        this.inventory = aInventory;
    }

    public void equip(Object aItem_itemName) {
        throw new UnsupportedOperationException();
    }

    public void unEquip(Object aItem_itemName) {
        throw new UnsupportedOperationException();
    }

    public void useItem(Object aItem_itemName) {
        throw new UnsupportedOperationException();
    }

    // 100 present chance to escape
    public void flee(Object aMonster_monster) {
        throw new UnsupportedOperationException();
    }

    // toString for Easy printing
    // author: Joseph Ongchangco
    public String toString() {
        String player = "player name: " + this.name + "\n";
        String health = "Health: " + this.name + "\n";
        String currentRoom = "Current room number: " + this.currentRoom + "\n";

        return player + health + currentRoom;
    }

    public double getAvoidChance() {
        throw new UnsupportedOperationException();
    }

    // sets to avoid chance which defaults at 75% chance of "avoiding" a monster
    public void setAvoidChance(double aDouble_value) {
        throw new UnsupportedOperationException();
    }
}