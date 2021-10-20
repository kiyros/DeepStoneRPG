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

	public void flee(Object aMonster_monster) {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return "";
	}

	public double getFleeChance() {
		throw new UnsupportedOperationException();
	}

	public void setFleeChance(Object aDouble_value) {
		throw new UnsupportedOperationException();
	}
}