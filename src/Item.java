import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type", visible = true)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = EquipItem.class, name = "equip"),
                @JsonSubTypes.Type(value = baseItem.class, name = "baseItem"),
                @JsonSubTypes.Type(value = WeaponItem.class, name = "weapon"),
                @JsonSubTypes.Type(value = PuzzleItem.class, name = "PuzzleItem"),
        })

abstract class Item {
    private String name;
    private String type;
    private String description;
    private boolean puzzle;
    private Integer roomNumber;


    // dummy constructor
    public Item() {

    }


    public boolean isPuzzle() {
        return puzzle;
    }

    public void setPuzzle(boolean puzzle) {
        this.puzzle = puzzle;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
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

    // sets the type of item, [puzzle][HealthConsumable][weaponItem]
    //@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
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
@JsonTypeName("baseItem")
class baseItem extends Item {
    // collectable????
}


// todo: equip item
@JsonTypeName("equip")
class EquipItem extends Item {
    private String statType;
    private double statBoost;

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public double getStatBoost() {
        return statBoost;
    }

    public void setStatBoost(double statBoost) {
        this.statBoost = statBoost;
    }
}

@JsonTypeName("weapon")
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

    public String inspect() {
        return getName() + "\nDamage : " + getDamage();
    }
}

// puzzle item
@JsonTypeName("PuzzleItem")
class PuzzleItem extends Item {

}

class HealthConsumable extends Item {
    private int _healthValue;

    public int getHealthValue() {
        return this._healthValue;
    }

    public void setHealthValue(int aHealthValue) {
        this._healthValue = aHealthValue;
    }
}