package game;

import java.util.HashMap;
import java.util.Map;

public class Chest extends Item {
	
	private Map<String, Item> content = new HashMap<>();
	
	public Chest(String name, String description) {
		super(name, false, description);
	}	
	
	public Map<String, Item> getContent() {
		return this.content;
	}
	
	public void supprObj(String name) {
		this.content.remove(name);
	}
	
	public void addObj(String name, Item object) {
		this.content.put(name, object);
	}
	
	@Override 
	public void print() {
		super.print();
		this.printContent();
	}
	
	public void printContent() {
		System.out.println("There are :");
		if (!(this.content.isEmpty()))
			this.content.forEach((k, v) -> {System.out.println(k);});
		else {
			System.out.println("nothing J.S.");
		}
	}
}
