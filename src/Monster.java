public class Monster {
	private String _name;
	private int _health;
	private int attack;
	private int defense;
	private String _description;
	public Room _unnamed_Room_;

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public int getHealth() {
		return this._health;
	}

	public void setHealth(int aHealth) {
		this._health = aHealth;
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
		return this._description;
	}

	public void setDescription(String aDescription) {
		this._description = aDescription;
	}

	public String toString() {
		return "";
	}
}