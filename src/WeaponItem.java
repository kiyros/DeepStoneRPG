public class WeaponItem extends Item {
	private int _damage;

	// gets the damage from a weapon item
	public int getDamage() {
		return this._damage;
	}

	// sets the damage for a weapon item
	public void setDamage(int aDamage) {
		this._damage = aDamage;
	}
}