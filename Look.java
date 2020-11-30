package game;

import java.util.List;

public class Look extends Command{

	private static final int NB_ARG_MAX = 1;
	private static final int NB_ARG_MIN = 0;


	public Look(World world, Hero hero, Game game) {
		super(world, hero, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean argOk(List<String> argument) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (argument.size() == Look.NB_ARG_MIN ){
			result = true;
		} else if (argument.size() == Look.NB_ARG_MAX){
			result = this.getHero().getPlace().getInteractions().containsKey(argument.get(NB_ARG_MIN));
		}
		else
			result = false;
		return result;
	}

	@Override
	public void launchCommand(List<String> argument) {
		// TODO Auto-generated method stub
		if (argument.size() == Look.NB_ARG_MIN ){
			this.getHero().look();
		} else if (argument.size() == Look.NB_ARG_MAX){
			this.getHero().look(this.getHero().getPlace().getInteractions().get(argument.get(0)));
		}
		
	}


}
