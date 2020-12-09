package game;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class KeyTest {
    
    private Key k1;
    private Receiver r1;

   
    @Before
    public void SetUp(){
        String name = "key_one";
        String description = "that's the key_one";
        k1 = new Key(name, description);
        Door d1 = new Door("door");
    }

    @Test
    public void getName() {
        assertEquals(k1.getName(), "key_one");
    }

    @Test
    public void isTakable() {
        assertTrue(k1.isTakable());
    }

    @Test
    public void use_Receiver() {
        assertDoesNotThrow(() -> k1.use(r1));
    }
    
}
