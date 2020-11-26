package game;

import java.util.*;

public class Door {

	private Place entree;
	private Place sortie;
	private static int currentId = 0;
	private int id;
	private boolean isOpen;

	public Door() {
		// TODO - implement game.Door.game.Door
		throw new UnsupportedOperationException();
	}

	public int getId() {
		//incroyable du  cul
		return this.id;
	}

	public boolean getIsOpen() {
		return this.isOpen;
	}

	public boolean open() {
		// TODO - implement game.Door.open
		throw new UnsupportedOperationException();
	}

	public boolean close() {
		// TODO - implement game.Door.close
		throw new UnsupportedOperationException();
	}

	public Place getEntree() {
		return entree;
	}

	public Place getSortie() {
		return sortie;
	}

}