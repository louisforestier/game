package game;

public class Guard extends NonPlayerCharacter{

    private static boolean DEFAULT_HOSTILE = true;
    private static int DEFAULT_HP = 7;
    private static int DEFAULT_ATTACK_BONUS = 4;
    private static  int DEFAULT_DAMAGE_BONUS = 2;


    public Guard(String name, String description) {
        super(name, description, Guard.DEFAULT_HOSTILE, Guard.DEFAULT_HP, Guard.DEFAULT_ATTACK_BONUS, Guard.DEFAULT_ATTACK_BONUS);
    }
}
