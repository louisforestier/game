package game;

import java.util.List;

public class Go extends Command {

    private static final int NB_ARG = 1;
    private static Hero hero;

    public Go(Hero hero) {
        super();
        Go.hero = hero;
    }


    public Door convertStringToDoor(String name) throws  ClassCastException{
        Place p = hero.getPlace();
        return (Door) p.getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws ClassCastException, NullPointerException , InvalidArgumentNumberException{
        if (argument.size() == Go.NB_ARG) {
            Door door = this.convertStringToDoor(argument.get(0));
            hero.go(door);
        } else throw new InvalidArgumentNumberException();
    }


	@Override
	public void help() {
		System.out.println("go name_of_location");	
	}


}
