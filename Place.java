package game;

import java.util.*;

public class Place implements Lookable {

	private final String name;
	private final String description;
	private Map<String, Lookable> interactions = new HashMap<>();

	/**
	 *
	 * @param name
	 * @param characters
	 * @param doors
	 * @param items
	 */
	public Place(String name, String description, Map<String, Lookable> interactions) {
		this.name = name;
		this.description = description;
		//peut throw exception : NullPointerException : faire try catch
		try {
			this.interactions.putAll(interactions);
		}
		catch (NullPointerException e){
			//dans le cas où la liste des interactions est vide, on ne fait rien
			//potentiellement à transformer en if else
		}
	}

	public Map<String, Lookable> getInteractions(){
		return this.interactions;
	}

	public void print() {
		System.out.print(this.description);
	}

	public String getName() {
		return this.name;
	}
	
	public void addCharacter(String name, Character c) {
		this.interactions.put(name, c);
	}

	public void freeCharacter(String name) {
		this.interactions.remove(name);
	}

	public  boolean isInPlace(String name) {
		return this.getInteractions().containsKey(name);
	}

}






