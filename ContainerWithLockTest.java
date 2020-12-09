package game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class ContainerWithLockTest {
	private ContainerWithLock chest;
    private Book book;
    private Key key;

    @Before
    public void setUp(){
    	key = new Key("key", "is key");
    	chest = new ContainerWithLock("chest", "is chest",key);
    	book = new Book("book", "is book", "oui");
    }
    
    @Test
	public void unlock() {
		assertFalse(chest.unlock(key));
	}

	@Test
	public void lock() {
		assertTrue(chest.lock(key));
	}
	
	@Test
	public void receiveForKey() {
		chest.receiveForKey(key);
    	assertFalse(chest.getIsLocked());
	}
	
	@Test
    public void receive1(){
		assertThrows(ClassCastException.class, () -> chest.receive(book));
    }
	
	@Test
    public void receive2(){
		assertDoesNotThrow(() -> chest.receive(key));
    }
	
	@Test
	public void addObj1() {
		chest.unlock(key);
		chest.addItem("book", book);
		assertNotNull(chest.getContent());
	}
	
	@Test
	public void addObj2() {
		chest.addItem("book", book);
		assertTrue(chest.getContent().isEmpty());
	}
	
	@Test
	public void supprObj1() {
		chest.unlock(key);
		chest.addItem("book", book);
		chest.removeItem("book");
		assertTrue(chest.getContent().isEmpty());
	}
	
	@Test
	public void supprObj2() {
		chest.unlock(key);
		chest.addItem("book", book);
		chest.lock(key);
		chest.removeItem("book");
		assertNotNull(chest.getContent());
	}
	
	

}
