package game;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ContainerTest {
	private Container chest;
    private Book book;

    @Before
    public void setUp(){
    	chest = new Container("chest", "is chest");
    	book = new Book("book", "is book", "oui");
    }
    
    @Test
    public void addObj() {
    	chest.addObj("book", book);
		assertTrue(chest.getContent().containsKey("book"));
	}
  
	@Test
	public void supprObj() {
		chest.addObj("book", book);
		chest.supprObj("book");
		assertTrue(chest.getContent().isEmpty());
	}

}
