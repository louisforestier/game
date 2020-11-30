package game;

import java.util.List;

public class Take extends Command{

	public Take(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public boolean argOk(List<String> argument) {
		boolean result = argument.size() == 1
				&& this.getHero().getPlace().getInteractions().containsKey(argument.get(0))
				&& this.getHero().getPlace().getInteractions().get(argument.get(0)) instanceof Item;
		return result;
	}

	@Override
	public void launchCommand(List<String> argument) {
		this.getHero().take((Item)this.getHero().getPlace().getInteractions().get(argument.get(0)));
	}

}
