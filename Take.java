package game;

import java.util.List;

public class Take extends Command {

    private static final int NB_ARG_MIN = 1;
    private static final int NB_ARG_MAX = 2;
    
    private static Hero hero;

    public Take(Hero hero) {
        super();
        Take.hero = hero;
    }

    public Item stringToItemInPlace(String name) throws ClassCastException {
        return (Item) hero.getPlace().getInteractions().get(name);
    }
    
    public Container stringToContainerInPlace(String name) throws ClassCastException {
    	return (Container) hero.getPlace().getInteractions().get(name);
    }
    
    public Item stringToItemInContainer(String name, Container chest) {
    	return chest.getContent().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException, ClassCastException {
        if (argument.size() == NB_ARG_MIN) {
            Item i = this.stringToItemInPlace(argument.get(0));
            if (i.isTakable()) {
                hero.take(i);
                System.out.println("You add " + i.getName() + " to your inventory.");
            } else System.out.println("You can't take this.");
        } else if (argument.size() == NB_ARG_MAX){
        	Container chest = this.stringToContainerInPlace(argument.get(0));
        	Item i = this.stringToItemInContainer(argument.get(1), chest);
        	if (i.isTakable()) {
        		hero.takeFromChest(chest, i);
        		System.out.println("You add " + i.getName() + " to your inventory.");
        	}
        } else throw new InvalidArgumentNumberException();
    }

	@Override
	public void help() {
		System.out.println("take name_of_object");
		System.out.println("take name_of_chest name_of_object");
	}

}
