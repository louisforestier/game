package game;

import java.util.List;
import java.util.Map;

public class Use extends Command {

	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;

	private static Hero hero;

	public Use(Hero hero) {
		super();
		Use.hero = hero;
	}

	public Map<String, Interaction> objectsInPlaceOfHero() {
		return hero.getPlace().getInteractions();
	}

	public Place getPlaceOfHero() {
		return hero.getPlace();
	}

	public Usable convertStringToUsable(String name) throws ClassCastException{
		Usable u;
		if (this.getPlaceOfHero().isInPlace(name)) {
			u = (Usable) this.objectsInPlaceOfHero().get(name);
		} else {
			u = (Usable) hero.getInventory().get(name);
		}
		return u;
	}


	public Receiver convertStringToReceiver(String name) throws ClassCastException{
		Receiver r;
		if (this.getPlaceOfHero().isInPlace(name)) {
			r = (Receiver) this.objectsInPlaceOfHero().get(name);
		} else {
			r = (Receiver) hero.getInventory().get(name);
		}
		return r;
	}

	@Override
	public void launchCommand(List<String> argument) throws ClassCastException, InvalidArgumentNumberException, NullPointerException {
		if(argument.size() == Use.NB_ARG_MIN) {
                    //System.out.println("You have used " + argument.get(0) + ".");
                    hero.use(this.convertStringToUsable(argument.get(0)));	
		} else if (argument.size() == Use.NB_ARG_MAX) {			
                    //System.out.println("You have used " + argument.get(0) + " on " + argument.get(1) + ".");
                    hero.use(this.convertStringToUsable(argument.get(0)), this.convertStringToReceiver(argument.get(1)));
		} else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		System.out.println("use name_of_object");
		System.out.println("use object_you_want_to_use object_on_which_you_use");
	}

}


