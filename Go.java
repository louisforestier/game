package game;

import java.util.List;

public class Go extends Command {

    private static final int NB_ARG = 1;


    public Go(World world, Hero hero, Game game) {
        super(world, hero, game);
    }


    public Door convertStringToDoor(String name) throws  ClassCastException{
        Place p = this.getHero().getPlace();
        return (Door) p.getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws ClassCastException, NullPointerException , InvalidArgumentNumberException{
        if (argument.size() == Go.NB_ARG) {
            Door door = this.convertStringToDoor(argument.get(0));
            this.getHero().go(door);
        } else throw new InvalidArgumentNumberException();
    }


	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}


}
