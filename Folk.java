package game;

import java.util.Scanner;

public class Folk extends NonPlayerCharacter implements Talkable {

    private Dialog dialog;

    public Folk(String name, String description, boolean isHostile, Dialog dialog, int maxHealthPoints, int attackBonus, int damageBonus) {
        super(name, description, isHostile, maxHealthPoints, attackBonus, damageBonus);
        this.dialog = dialog;
    }

    @Override
    public void talk(Talkable t, Scanner input) {
        if (this.isAlive()) {
            if (!this.isHostile())
                this.dialog.startDialog(t, this, input);
            else System.out.println("This one doesn't want to talk to you.");
        } else {
            System.out.println("Now you're talking to dead people.");
        }
    }


}
