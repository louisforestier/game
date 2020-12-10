package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
	private Container chest;
    private Book book;

    @BeforeEach
    public void setUp(){
    	chest = new Container("chest", "is chest");
    	book = new Book("book", "is book", "oui");
    }
    
    @Test
	//test fonctionnel
	public void addObj() {
    	chest.addItem("book", book);
		assertTrue(chest.getContent().containsKey("book"));
	}
  
	@Test
	//test fonctionnel
	public void supprObj() {
		chest.addItem("book", book);
		chest.removeItem("book");
		assertTrue(chest.getContent().isEmpty());
	}

}
