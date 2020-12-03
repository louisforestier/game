package game;

public abstract class Item extends Interaction {

    private String name;
    private boolean takable;

    /**
     * @param name
     */

    public Item(String name, boolean takable, String description) {
        super(description);
        this.name = name;
        this.takable = takable;
    }

    public String getName() {
        return this.name;
    }

    public boolean isTakable() {
        return this.takable;
    }
}