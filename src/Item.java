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
