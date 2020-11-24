package game;

import java.util.*;

public abstract class Character {

	Collection<Item> inventory;
	private Place place;
	private static int currentId = 0;
	private int id;
	private String name;

	/**
	 * 
	 * @param s
	 */
	public Character(String s) {
		// TODO - implement game.Character.game.Character
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}