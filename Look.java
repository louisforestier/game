package game;

import java.util.List;

public class Look extends Command{

	private static final int NB_ARG_MAX = 1;
	private static final int NB_ARG_MIN = 0;

	private static Hero hero;
	
	public Look(Hero hero) {
		super();
		Look.hero = hero;
	}

	@Override
	public void launchCommand(List<String> argument) throws NullPointerException, InvalidArgumentNumberException{
		if (argument.size() == Look.NB_ARG_MIN ){
			hero.look();
		} else if (argument.size() == Look.NB_ARG_MAX){
			hero.look(hero.getPlace().getInteractions().get(argument.get(0)));
		} else throw new InvalidArgumentNumberException();
		
	}

	@Override
	public void help() {
		System.out.println("look");
		System.out.println("look name_of_object");
	}


}
