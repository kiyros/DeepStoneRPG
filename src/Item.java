abstract class Item {
    private String name;
    private String type;
    private String description;

    // sets the name of an item
    public String getName() {
        return name;
    }

    // sets the name of the item
    public void setName(String name) {
        this.name = name;
    }

    // the type of an item, [puzzle][HealthConsumable][weaponItem]
    public String getType() {
        return type;
    }

    // sets the type of an item, [puzzle][HealthConsumable][weaponItem]
    public void setType(String type) {
        this.type = type;
    }

    // gets the description for an item
    public String getDescription() {
        return description;
    }

    // sets description for an item
    public void setDescription(String description) {
        this.description = description;
    }

    // return to string for view
    public String toString() {
        return "";
    }
}

// misc item
// todo: misc item
class MiscItem extends Item {
    // collectable????
}

// puzzle item
// todo: puzzle item
class PuzzleItem extends Item {

}

// puzzle item
// todo: equip item
class EquipItem extends Item {
    private String statType;
    private int statBoostAmount;

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public int getStatBoostAmount() {
        return statBoostAmount;
    }

    public void setStatBoostAmount(int statBoostAmount) {
        this.statBoostAmount = statBoostAmount;
    }
}

class WeaponItem extends Item {
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