package game;

import java.util.HashMap;
import java.util.Map;

public class Chest extends Item {
	
	private Map<String, Item> content = new HashMap<>();
	private boolean isOpen;
	
	public Chest(String name, boolean takable, String description) {
		super(name, takable, description);
		this.isOpen = false;
	}	
	
	public Map<String, Item> getContent() {
		return this.content;
	}
	
	public boolean isOpen() {
		return this.isOpen;
	}
	
	public void supprObj(String name) {
		this.content.remove(name);
	}
	
	public void addObj(String name, Item object) {
		this.content.put(name, object);
	}
	
	public boolean open() {
		this.isOpen = true;
		return this.isOpen;
	}
	
	public boolean close() {
		this.isOpen = false;
		return this.isOpen;
	}
	
	@Override 
	public void print() {
        super.print();
        if(this.isOpen) {
        	System.out.println("There are :");
        	if (!(this.content.isEmpty()))
        		this.content.forEach((k, v) -> {v.print();});
        	else {
        		System.out.println("nothing J.S.");
        	}
        }
    }
	
}
