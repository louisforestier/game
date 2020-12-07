package game;

public class Door extends Interaction {

    private Place entrance;
    private Place exit;

    public Door(String description) {
        super(description);
        this.entrance = null;
        this.exit = null;
    }

    public void setEntrance(Place entrance) {
        this.entrance = entrance;
    }

    public void setExit(Place exit) {
        this.exit = exit;
    }

    public Place getEntrance() {
        return this.entrance;
    }

    public Place getExit() {
        return this.exit;
    }

    public Place cross() {
        return this.exit;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("It seems to lead to the " + this.getExit().getName() + ".");
    }
}