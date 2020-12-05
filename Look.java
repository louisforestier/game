package game;

import java.util.List;

public class Look extends Command{

	private static final int NB_ARG_MAX = 1;
	private static final int NB_ARG_MIN = 0;


	public Look(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public void launchCommand(List<String> argument) throws NullPointerException, InvalidArgumentNumberException{
		if (argument.size() == Look.NB_ARG_MIN ){
			this.getHero().look();
		} else if (argument.size() == Look.NB_ARG_MAX){
			this.getHero().look(this.getHero().getPlace().getInteractions().get(argument.get(0)));
		} else throw new InvalidArgumentNumberException();
		
	}


}
