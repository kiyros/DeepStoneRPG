import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Puzzle {
    private String name;
    private String riddle;
    private String solution;
    private boolean solved;
    private String hint;
    private String itemReward;
    private ArrayList<Integer> roomUnlock;
    private int roomNumber;

    // puts the room in a condition, like everytime you pick up an item, you fight a random monster
    private HashMap<String, Integer> Penalty;

    public HashMap<String, Integer> getPenalty() {
        return Penalty;
    }

    public void setPenalty(HashMap<String, Integer> penalty) {
        Penalty = penalty;
    }

    public ArrayList<Integer> getRoomUnlock() {
        return roomUnlock;
    }

    public void setRoomUnlock(ArrayList<Integer> roomUnlock) {
        this.roomUnlock = roomUnlock;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRiddle() {
        return this.riddle;
    }

    public void setRiddle(String aRiddle) {
        this.riddle = aRiddle;
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

    public String getItemReward() {
        return this.itemReward;
    }

    public void setItemReward(String aItemReward) {
        this.itemReward = aItemReward;
    }

    public String toString() {
        String title = "Puzzle: " + this.name + "\n";
        String riddle = "riddle: " + this.riddle + "\n";
        String modifier = "";

        if (this.Penalty != null) {
            modifier = this.Penalty + "\n";
        }

        return title + riddle + modifier;
    }
}