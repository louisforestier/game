package game;

import java.util.Iterator;
import java.util.List;

public class Take extends Command {

    public Take(World world, Hero hero, Game game) {
        super(world, hero, game);
    }

    public Item stringToItemInPlace(String name) {
        return (Item) this.getHero().getPlace().getInteractions().get(name);
    }

    @Override
    public boolean argOk(List<String> argument) {
        boolean result = false;
        if (argument.size() == 1) {
            if (this.getHero().getPlace().isInPlace(argument.get(0))) {
                if (this.getHero().getPlace().getInteractions().get(argument.get(0)) instanceof Item)
                    result = this.stringToItemInPlace(argument.get(0)).isTakable();
                else
                    System.out.println("You can't take that !");
            } else
                System.out.println("There is no " + argument.get(0) + "in this place.");

        } else
            System.out.println("You should specify what you want to take.");
        return result;
    }

    @Override
    public void launchCommand(List<String> argument) {
        this.getHero().take(this.stringToItemInPlace(argument.get(0)));
    }

}
