import java.util.ArrayList;

public class Puzzle {
	private String _riddle;
	private String _type;
	private String _solution;
	private boolean _solved;
	private String _hint;
	private Item _itemReward;
	private ArrayList<Integer> _roomUnlock;
	private String _puzzleModifier;
	public Room _unnamed_Room_;

	public String getRiddle() {
		return this._riddle;
	}

	public void setRiddle(String aRiddle) {
		this._riddle = aRiddle;
	}

	public String getType() {
		return this._type;
	}

	public void setType(String aType) {
		this._type = aType;
	}

	public String getSolution() {
		return this._solution;
	}

	public void setSolution(String aSolution) {
		this._solution = aSolution;
	}

	public boolean getSolved() {
		return this._solved;
	}

	public void setSolved(boolean aSolved) {
		this._solved = aSolved;
	}

	public String getHint() {
		return this._hint;
	}

	public void setHint(String aHint) {
		this._hint = aHint;
	}

	public Item getItemReward() {
		return this._itemReward;
	}

	public void setItemReward(Item aItemReward) {
		this._itemReward = aItemReward;
	}

	public ArrayList<Integer> getRoomUnlock() {
		throw new UnsupportedOperationException();
	}

	public void setRoomUnlock(ArrayList<Integer> aRoomUnlock) {
		throw new UnsupportedOperationException();
	}

	public String getPuzzleModifier() {
		return this._puzzleModifier;
	}

	public void setPuzzleModifier(String aPuzzleModifier) {
		this._puzzleModifier = aPuzzleModifier;
	}
}