package game;

public class King extends Folk {
	
	private static boolean DEFAULT_HOSTILE = false;
	private static int DEFAULT_HP = 12;
	private static int DEFAULT_ATTACK_BONUS = 3;
	private static  int DEFAULT_DAMAGE_BONUS = 2;

	public King(String name, String description, Dialog dialog){
		super(name, description, King.DEFAULT_HOSTILE, dialog, King.DEFAULT_HP, King.DEFAULT_ATTACK_BONUS, King.DEFAULT_DAMAGE_BONUS);
	}
	
}
