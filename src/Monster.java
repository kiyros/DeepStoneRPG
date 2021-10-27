import java.util.ArrayList;

public class Monster extends Entity{



    private String itemDropName;
    public Room _unnamed_Room_;

    public Monster(String name, int health, String description) {
        super(name, health, description);
    }

    public String getItemDropName() {
        return itemDropName;
    }

    public void setItemDropName(String itemDropName) {
        this.itemDropName = itemDropName;
    }





    public String toString() {
        return "";
    }
}