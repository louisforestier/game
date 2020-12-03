package game;

import java.util.List;

public class Go extends Command {

    private static final int NB_ARG = 1;


    public Go(World world, Hero hero, Game game) {
        super(world, hero, game);
    }


    @Override
    public boolean argOk(List<String> argument) {
        boolean result;
        String param;
        if (argument.size() != Go.NB_ARG) {
            result = false;
        } else {
            param = argument.get(0);
            if (this.getWorld().isInWorld(param)) {
                result = this.getHero().getPlace().getInteractions().containsKey(param);
            } else result = false;
        }
        return result;
    }

    public Door convertStringToDoor(String name) {
        Place p = this.getHero().getPlace();
        return (Door) p.getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) {
        Door door = this.convertStringToDoor(argument.get(0));
        this.getHero().go(door);
    }


}
