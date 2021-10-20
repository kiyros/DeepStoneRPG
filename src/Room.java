import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Room {

	// main attributes
	private String name;
	private int roomID;
	private String description;
	private HashMap<String, Integer> exits;
	private ArrayList<Integer> lockedExits;

	// Object attributes addon
	private ArrayList<Item> items;
	private Puzzle puzzle;
	private ArrayList<Monster> monsters;
	private boolean visited;


	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void getPuzzle() {
		throw new UnsupportedOperationException();
	}

	public void setPuzzle(Object aPuzzle) {
		throw new UnsupportedOperationException();
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
		String name = "Name: " + this.name + "\n";
		String roomNumber = "room ID: " +  this.roomID + "\n";
		String desc = "Description: " + this.description + "\n";


		String visited = "you have not visited this room before \n";
		StringBuilder monster = new StringBuilder("");
		StringBuilder items = new StringBuilder("");
		String puzzle = "";

		if(getVisited()){
			visited = "[[You have visited this room before]] \n";
		}

		if(!this.monsters.isEmpty()){
			monster = new StringBuilder("[monster(s)]: \n");
			for (Monster m : this.monsters){
				monster.append(m.getName()).append("\n");
			}
		}

		if(this.puzzle != null){
			puzzle = "[puzzle]: \n" + this.puzzle;
		}

		if(!this.items.isEmpty()){
			items = new StringBuilder("[item(s)]: \n");
			for (Item i : this.items){
				items.append(i.getName()).append("\n");
			}
		}

		return name + roomNumber + desc + visited + monster + puzzle + items;
	}

	public ArrayList<Integer> getLockedExits() {
		throw new UnsupportedOperationException();
	}

	public void setLockedExits(ArrayList<Integer> aLockedExits) {
		throw new UnsupportedOperationException();
	}
}