import java.util.ArrayList;

public class Puzzle {
	private String name;
	private String riddle;
	private String type;
	private String solution;
	private boolean solved;
	private String hint;
	private Item itemReward;
	private ArrayList<Integer> roomUnlock;

	// puts the room in a condition, like everytime you pick up an item, you fight a random monster
	private String puzzleModifier;

	public String getRiddle() {
		return this.riddle;
	}

	public void setRiddle(String aRiddle) {
		this.riddle = aRiddle;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String aType) {
		this.type = aType;
	}

	public String getSolution() {
		return this.solution;
	}

	public void setSolution(String aSolution) {
		this.solution = aSolution;
	}

	public void setSolved(boolean aSolved) {
		this.solved = aSolved;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSolved() {
		return solved;
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String aHint) {
		this.hint = aHint;
	}

	public Item getItemReward() {
		return this.itemReward;
	}

	public void setItemReward(Item aItemReward) {
		this.itemReward = aItemReward;
	}

	public ArrayList<Integer> getRoomUnlock() {
		throw new UnsupportedOperationException();
	}

	public void setRoomUnlock(ArrayList<Integer> aRoomUnlock) {
		throw new UnsupportedOperationException();
	}

	public String getPuzzleModifier() {
		return this.puzzleModifier;
	}

	public void setPuzzleModifier(String aPuzzleModifier) {
		this.puzzleModifier = aPuzzleModifier;
	}

	public String toString() {
		String title = "Puzzle: " + this.name + "\n";
		String riddle = "riddle: "+ this.riddle + "\n";
		String modifier = "";

		if(this.puzzleModifier != null){
			modifier = this.puzzleModifier + "\n";
		}

		return title + riddle + modifier;
	}
}