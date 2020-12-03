package game;

public abstract class Interaction {

    private final String description;

    public Interaction(String description) {
        this.description = description;
    }

    public void print() {
        System.out.println(this.description);
    }

}