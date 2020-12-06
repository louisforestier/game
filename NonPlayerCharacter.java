package game;

public class NonPlayerCharacter extends Character {
    private boolean isHostile;

    public NonPlayerCharacter(String name, String description, boolean isHostile) {
        super(name, description);
        this.isHostile = isHostile;
    }

}
