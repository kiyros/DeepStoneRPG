import java.util.ArrayList;

public class Player {
    private String name;
    private String description;
    private int currentRoom = 0;
    private ArrayList<Item> inventory;
    private final Item equipedItem;

    // player values
    private int health;
    private int defense;
    private int damage;

    public int getDefense() {
        return defense;
    }

    public Player() {
        this.inventory = new ArrayList<>();
        this.equipedItem = null;
    }

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

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // toString for Easy printing
    // author: Joseph Ongchangco
    public String toString() {
        String player = "player name: " + this.name + "\n";
        String health = "Health: " + this.name + "\n";
        String currentRoom = "Current room number: " + this.currentRoom + "\n";

        return player + health + currentRoom;
    }

    public String inventoryToString() {
        StringBuilder inventory = new StringBuilder("[Inventory] : \n");

        for (Item i : this.inventory) {
            inventory.append(i.getName()).append("\n");
        }

        return inventory.toString();
    }

    // picks up an item in the current room by item name or integer
    // author : Joseph Ongchangco
    public String pickupItem(Room room, String item){
        try {
            for (Item i : room.getItems()){
                // String
                if(i.getName().equals(item)){
                    inventory.add(i);
                    room.getItems().remove(i);
                }
                // int
                else if(room.getItems().size() >= Integer.parseInt(item)-1){
                    inventory.add(i);
                    room.getItems().remove(i);
                }
                else{
                    return "[Item] does not exist in this room";
                }
                return "Added [item] : " + i.getName() +" to inventory";
            }
        }catch(Exception ignored){
            ;
        }
        return "[Item] does not exist in this room";
    }


    // sets to avoid chance which defaults at 75% chance of "avoiding" a monster
    public void setAvoidChance(double aDouble_value) {
        throw new UnsupportedOperationException();
    }
}