import java.util.ArrayList;
public class Monster extends Entity{
    private String name;
    private int health;
	private int attack;
	private int defense;
	private String description;
	private String itemDropName;

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

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
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