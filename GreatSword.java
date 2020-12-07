package game;

public class GreatSword extends Weapon {

	private final static int DEFAULT_ATTACK_POWER = 12;

	public GreatSword(String name, String description) {
		super(name, description, GreatSword.DEFAULT_ATTACK_POWER);
	}

	public GreatSword(String name, String description, int attackPowerBonus) {
		super(name, description, GreatSword.DEFAULT_ATTACK_POWER + attackPowerBonus);
	}

}
