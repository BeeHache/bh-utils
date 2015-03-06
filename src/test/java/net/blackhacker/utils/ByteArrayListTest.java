package net.blackhacker.utils;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class ByteArrayListTest {
    
	static Random rand;
    
    public ByteArrayListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    	rand = new Random();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void fromByteArrayTest() {
        ByteArrayList fromByteArray = ByteArrayList.fromByteArray(null);
        assertNotNull(fromByteArray);
        assertEquals(fromByteArray.size(), 0);        
    }
    
    @Test
    public void toByteArrayTest() {
        ByteArrayList bal = new ByteArrayList();
        byte[] a = bal.toByteArray();
        assertNotNull(a);
        //byte array always has a 4 byte header
        assertEquals(a.length,4);
    }
    
    
    
    @Test
    public void test() {
        ByteArrayList bal1 = new ByteArrayList();
        int rows = rand.nextInt(1000) + 1;
        
        for(int r=0; r < rows; r++){
            int cols = rand.nextInt(100) + 1;
            byte[] row = new byte[cols];
            rand.nextBytes(row);
            bal1.add(row);
        }
        
        byte[] ba = bal1.toByteArray();
        ByteArrayList bal2 = ByteArrayList.fromByteArray(ba);
     
        assertEquals(bal1,bal2);
    }
}
