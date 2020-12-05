package game;

import java.util.List;

public class Take extends Command {

    public static final int NB_ARG = 1;

    public Take(World world, Hero hero, Game game) {
        super(world, hero, game);
    }

    public Item stringToItemInPlace(String name) throws ClassCastException {
        return (Item) this.getHero().getPlace().getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException, ClassCastException {
        if (argument.size() == NB_ARG) {
            this.getHero().take(this.stringToItemInPlace(argument.get(0)));
            System.out.println("You add " + argument.get(0) + " to your inventory.");
        }

        else throw new InvalidArgumentNumberException();
    }

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
