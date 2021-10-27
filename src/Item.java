abstract class Item {
    private String name;
    private String type;
    private String description;
    private boolean puzzle;

    public boolean isPuzzle() {
        return puzzle;
    }

    public void setPuzzle(boolean puzzle) {
        this.puzzle = puzzle;
    }
    
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
        return name;
    }
}

// baseItem, the generic item holder
class baseItem extends Item {
    // collectable????
}

// puzzle item
// todo: equip item
class EquipItem extends Item {
    private String statType;
    private double statBoostAmount;

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public double getStatBoostAmount() {
        return statBoostAmount;
    }

    public void setStatBoostAmount(double statBoostAmount) {
        this.statBoostAmount = statBoostAmount;
    }
}

class WeaponItem extends Item {
    private int damage;

    // gets the damage from a weapon item
    public int getDamage() {
        return this.damage;
    }

    // sets the damage for a weapon item
    public void setDamage(int aDamage) {
        this.damage = aDamage;
    }

    @Override
    public String toString() {
        return "";
    }
}

class PuzzleItem extends Item {}

class HealthConsumable extends Item {
    private int _healthValue;

    public int getHealthValue() {
        return this._healthValue;
    }

    public void setHealthValue(int aHealthValue) {
        this._healthValue = aHealthValue;
    }
}