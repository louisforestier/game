package game;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KeyTest {
    
    private Key k1;
    private Receiver r1;
    private Door d1;
   
    @Before
    public void SetUp(){
        String name = "key_one";
        String description = "that's the key_one";
        k1 = new Key(name, description);
        d1 = new Door("door");
    }

    @Test
    public String getName() {
        assertEquals(k1.getName(), "key_one");
    }

    @Test
    public boolean isTakable() {
        assertTrue(k1.isTakable());
    }
    
    @Test
    public void use(){
    }
    
    @Test
    public void use_Receiver1() {
        assertThrows(ClassCastException.class, () -> k1.use(d1));
    }
    
    @Test
    public void use_Receiver2() {
        assertDoesNotThrow(() -> k1.use(r1));
    }
    
}
