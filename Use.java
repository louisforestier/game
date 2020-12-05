package game;

import java.util.List;
import java.util.Map;

public class Use extends Command {

	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;


	public Use(Hero hero, Game game) {
		super(hero, game);
	}

	public Map<String, Interaction> objectsInPlaceOfHero() {
		return this.getHero().getPlace().getInteractions();
	}

	public Place getPlaceOfHero() {
		return this.getHero().getPlace();
	}

	public Usable convertStringToUsable(String name) throws ClassCastException{
		Usable u;
		if (this.getPlaceOfHero().isInPlace(name)) {
			u = (Usable) this.objectsInPlaceOfHero().get(name);
		} else {
			u = (Usable) this.getHero().getInventory().get(name);
		}
		return u;
	}


	public Receiver convertStringToReceiver(String name) throws ClassCastException{
		Receiver r;
		if (this.getPlaceOfHero().isInPlace(name)) {
			r = (Receiver) this.objectsInPlaceOfHero().get(name);
		} else {
			r = (Receiver) this.getHero().getInventory().get(name);
		}
		return r;
	}

	@Override
	public void launchCommand(List<String> argument) throws ClassCastException, InvalidArgumentNumberException, NullPointerException {
		if(argument.size() == Use.NB_ARG_MIN)
			this.getHero().use(this.convertStringToUsable(argument.get(0)));
		else if (argument.size() == Use.NB_ARG_MAX)
			this.getHero().use(this.convertStringToUsable(argument.get(0)), this.convertStringToReceiver(argument.get(1)));
		else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		System.out.println("use name_of_object");
		System.out.println("use object_you_want_to_use object_on_which_you_use");
	}

}


