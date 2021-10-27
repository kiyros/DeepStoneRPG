public class Entity {
    /*
    todo: set defense and attack here, both Player And Monster have these attributes
     */
    private String name;
    private int health;
    private String description;
    // todo: add attack and defense attributes and their GETTERS() and SETTERS()

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
