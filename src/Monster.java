import java.util.ArrayList;

public class Monster {
    private String name;
    private int health;
    private String description;
    private String itemDropName;
    public Room _unnamed_Room_;

    public String getItemDropName() {
        return itemDropName;
    }

    public void setItemDropName(String itemDropName) {
        this.itemDropName = itemDropName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int aHealth) {
        this.health = aHealth;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public String toString() {
        return "";
    }
}