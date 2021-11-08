import java.util.ArrayList;
import java.util.Iterator;

public class Player extends Entity {
    // player values
    private int currentRoom = 7;
    private ArrayList<Item> inventory;
    private ArrayList<Item> equipItems;

    //constructor

    public Player() {
        this.inventory = new ArrayList<>();
        this.equipItems = new ArrayList<>();
    }

    public ArrayList<Item> getEquipItems() {
        return equipItems;
    }

    public void setEquipItems(ArrayList<Item> equipItems) {
        this.equipItems = equipItems;
    }

    public int getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(int aCurrentRoom) {
        this.currentRoom = aCurrentRoom;
    }

    public ArrayList<Item> getInventory() {
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

    // toString for Easy printing
    // author: Joseph Ongchangco
    public String toString() {
        String player = "player name: " + super.getName() + "\n";
        String health = "Health: " + super.getHealth() + "\n";
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

    public String equipmentToString() { // Jawwad Qureshi
        StringBuilder equipItems = new StringBuilder("[Equipped Items] : \n");
        for (Item i : this.equipItems) {
            equipItems.append(i.getName()).append("\n");
        }

        return equipItems.toString();
    }

    // picks up an item in the current room by item name or integer
    // author : Joseph Ongchangco
    public String pickupItem(Room room, String item) {

        for (Item i : room.getItems()) {
            // String
            if (i.getName().equals(item)) {
                inventory.add(i);
                room.getItems().remove(i);
                return "Added [item] : [" + i + "] to inventory";
            }
            // int
            try {
                if (i == room.getItems().get(Integer.parseInt(item) - 1)) {
                    inventory.add(i);
                    room.getItems().remove(i);
                    return "Added [item] : [" + i + "] to inventory";
                }
            } catch (Exception ignored) {
            }
        }
        return "That item does not exist in this room, try spelling it right or selecting the index of the item";
    }

    public String equipItem(String equipment) { //Jawwad Qureshi and Joseph Ongchangco

        Iterator<Item> it = inventory.iterator();
        while (it.hasNext()){
            Item item = it.next();

            //System.out.println(item.getName());
            if(item.getName().equals(equipment)){
                equipItems.add(item);
                inventory.remove(item);
            try {
                EquipItem eq = (EquipItem) item;
                System.out.println(eq.getDamage() + " = item damage");
                System.out.println(eq.getStatBoost() + " = stats");
                if (eq.getName().equalsIgnoreCase("The Philosophers sword") || eq.getName().equalsIgnoreCase("Ragnarok")) {
                    System.out.println("Player attack before: " + getAttack());
                    setAttack((getAttack() + eq.getDamage()));

                    System.out.println("Player attack now: " + getAttack());
                } else if (eq.getStatType().equalsIgnoreCase("defense")) {
                    System.out.println("Player defense before: " + getDefense());
                    double x = getDefense() + (getAttack() * eq.getStatBoost());
                    setDefense((int) x);
                    System.out.println("Player defense now: " + getDefense());

                } else if (eq.getStatType().equalsIgnoreCase("damage")) {
                    System.out.println("Player attack before: " + getAttack());
                    double x = (getAttack() + (getAttack() * eq.getStatBoost()));
                    setAttack((int) x);
                    System.out.println("Player attack now: " + getAttack());

                } else if (eq.getStatType().equalsIgnoreCase("health")) {
                    System.out.println("Player health before: " + getHealth());
                    double x = (getHealth() + (getHealth() * eq.getStatBoost()));
                    setHealth((int) x);
                    System.out.println("Player health now: " + getHealth());
                }
            }
            catch (Exception ignore) {
                return "Item could not be equipped";
            }

                return "Item equipped";
            }
        }

        return "Item could not be found";



//        jawwad code
//        for (int i = 0; i < inventory.size(); i++) {
//            if (inventory.get(i).getName().equalsIgnoreCase(equipment) &&
//                    (inventory.get(i).getType().equalsIgnoreCase("weapon") || inventory.get(i).getType().equalsIgnoreCase("equip"))) {
//                equip = (EquipItem) inventory.get(i);
//                equipItems.add(inventory.get(i));
//                inventory.remove(i);
//
//            }
//        }

    }

    public String unequipItem(String equipment) { // Jawwad Qureshi
        Iterator<Item> it = equipItems.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if(item.getName().equals(equipment)) {
                inventory.add(item);
                equipItems.remove(item);
                try {
                    EquipItem eq = (EquipItem) item;

                    // TODO: return String here
                    if (eq.getName().equalsIgnoreCase("The Philosophers sword") || eq.getName().equalsIgnoreCase("Ragnarok")) {
                        System.out.println("Player attack before: " + getAttack());
                        setAttack((getAttack() - eq.getDamage()));
                        System.out.println("Player attack now: " + getAttack());

                    } else if (eq.getStatType().equalsIgnoreCase("defense")) {
                        System.out.println("Player defense before: " + getDefense());
                        double x = getDefense() - (getAttack() * eq.getStatBoost());
                        setDefense((int) x);
                        System.out.println("Player defense now: " + getDefense());

                    } else if (eq.getStatType().equalsIgnoreCase("damage")) {
                        System.out.println("Player attack before: " + getAttack());
                        double x = (getAttack() - (getAttack() * eq.getStatBoost()));
                        setAttack((int) x);
                        System.out.println("Player attack now: " + getAttack());

                    } else if (eq.getStatType().equalsIgnoreCase("health")) {
                        System.out.println("Player health before: " + getHealth());
                        double x = (getHealth() - (getHealth() * eq.getStatBoost()));
                        setHealth((int) x);
                        System.out.println("Player health now: " + getHealth());
                    }
                }
                catch (Exception ignore) {
                    return "Item could not be unequipped";
                }
                return "Item unequipped";
            }
        }
        return "Item could not be found";
    }

    public String drop(Room room, String item) {

        for (Item i : getInventory()) {
            // String
            if (i.getName().equals(item)) {
                room.getItems().add(i);
                getInventory().remove(i);
                return "Dropped [item] : [" + i + "] in Room";
            }
            // int
            try {
                if (i == getInventory().get(Integer.parseInt(item) - 1)) {
                    room.getItems().add(i);
                    getInventory().remove(i);
                    return "Dropped [item] : [" + i + "] into room";
                }
            } catch (Exception ignored) {
            }
        }
        return "That item does not exist in your inventory, try spelling it right or selecting the index of the item";
    }

    public String use(String item) {

        for (Item i : getInventory()) {
            if (i.getName().equals(item)) {
                getInventory().remove(i);
                return i.getName();
            }

            try {
                if (i == getInventory().get(Integer.parseInt(item) - 1)) {
                    getInventory().remove(i);
                    return i.getName();
                }
            } catch (Exception ignored) {
            }

        }
        return "That item does not exist in your inventory, try spelling it right or selecting the index of the item";
    }
}
