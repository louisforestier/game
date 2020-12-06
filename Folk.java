package game;

import java.util.Scanner;

public class Folk extends NonPlayerCharacter implements Talkable{

    private Dialog dialog;

    public Folk(String name, String description, boolean isHostile, Dialog dialog) {
        super(name, description, isHostile);
        this.dialog = dialog;
    }

    @Override
    public void talk(Talkable t, Scanner input) {
        this.dialog.startDialog(t, this, input);
    }
}
