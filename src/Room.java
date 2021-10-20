import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Room {
	private String name;
	private int roomID;
	private String description;
	private HashMap<String, Item> items;
	private Puzzle puzzle;
	private Monster monster;
	private HashMap<String, Integer> exits;
	private boolean visited;
	private ArrayList<Integer> lockedExits;


	public void getItems() {
		throw new UnsupportedOperationException();
	}

	public void setItems(Object aItems) {
		throw new UnsupportedOperationException();
	}

	public void getPuzzle() {
		throw new UnsupportedOperationException();
	}

	public void setPuzzle(Object aPuzzle) {
		throw new UnsupportedOperationException();
	}

	public void getMonster() {
		throw new UnsupportedOperationException();
	}

	public void setMonster(Object aMonster) {
		throw new UnsupportedOperationException();
	}

	public boolean getVisited() {
		return this.visited;
	}

	public void setVisited(boolean aVisited) {
		this.visited = aVisited;
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Integer> getLockedExits() {
		throw new UnsupportedOperationException();
	}

	public void setLockedExits(ArrayList<Integer> aLockedExits) {
		throw new UnsupportedOperationException();
	}
}