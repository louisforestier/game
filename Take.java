package game;

import java.util.List;

public class Take extends Command{

	public Take(World world, Hero hero, Game game) {
		super(world, hero, game);
	}


	@Override
	public boolean argOk(List<String> argument) {
		boolean result = false;
		if (argument.size() == 1){
			if (this.getHero().getPlace().getInteractions().containsKey(argument.get(0))){
				result = this.getHero().getPlace().getInteractions().get(argument.get(0)) instanceof Item;
			}
		}
		return result;
	}

	@Override
	public void launchCommand(List<String> argument) {
		this.getHero().take((Item)this.getHero().getPlace().getInteractions().get(argument.get(0)));
	}

}
