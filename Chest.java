package game;

import java.util.HashMap;
import java.util.Map;

public class Chest extends Item {
	
	private Map<String, Item> content = new HashMap<>();
	
	public Chest(String name, boolean takable, String description, Key key) {
		super(name, takable, description);
	}	
	
	public Map<String, Item> getContent() {
		return this.content;
	}
	
	public void supprObj(String name) {
		this.content.remove(name);
	}
	
	
}
