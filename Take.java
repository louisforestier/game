package game;

import java.util.List;

public class Take extends Command {

    public static final int NB_ARG_MIN = 1;
    public static final int NB_ARG_MAX = 2;

    public Take(Hero hero, Game game) {
        super(hero, game);
    }

    public Item stringToItemInPlace(String name) throws ClassCastException {
        return (Item) this.getHero().getPlace().getInteractions().get(name);
    }
    
    public Chest stringToChestInPlace(String name) throws ClassCastException {
    	return (Chest) this.getHero().getPlace().getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException, ClassCastException {
        if (argument.size() == NB_ARG_MIN) {
            Item i = this.stringToItemInPlace(argument.get(0));
            if (i.isTakable()) {
                this.getHero().take(i);
                System.out.println("You add " + argument.get(0) + " to your inventory.");
            } else System.out.println("You can't take this.");
        } else if (argument.size() == NB_ARG_MAX){
        	Chest chest = this.stringToChestInPlace(argument.get(0));
        	Item i = this.stringToItemInPlace(argument.get(1));
        	if (i.isTakable()) {
        		this.getHero().takeFromChest(chest, i);
        		System.out.println("You add " + argument.get(1) + " to your inventory.");
        	}
        } else throw new InvalidArgumentNumberException();
    }

	@Override
	public void help() {
		System.out.println("take name_of_object");
		System.out.println("take name_of_chest name_of_object");
	}

}
