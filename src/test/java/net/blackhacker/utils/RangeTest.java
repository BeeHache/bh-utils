package net.blackhacker.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.blackhacker.utils.range.Range;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RangeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        
        List<Object[]> l = new ArrayList<>(Arrays.asList(
            new Object[][] {
                {
                    Range.makeRange((byte)0),
                    Range.makeRange((byte)1),
                    Range.makeRange((byte)5),
                    Range.makeRange((byte)2,(byte)7,(byte)2),
                    Range.makeRange((byte)3,(byte)9,(byte)-4),
                },
                /*
                {Range.makeRange(start, stop)},
                {Range.makeRange(start,stop, 2)},

                {Range.makeRange((char)start)},
                {Range.makeRange((char)start, (char)stop)},
                {Range.makeRange((char)start, (char)stop, (char)2)},
                */
            }
        ));
        
        return l;
    }

    final Iterable<?> i0;    
    final Iterable<?> i1;    
    final Iterable<?> i2;
    final Iterable<?> i3;
    final Iterable<?> i4;
        
    public RangeTest(Iterable<?> i0, Iterable<?> i1,Iterable<?> i2,Iterable<?> i3,
            Iterable<?> i4) {
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        /*
        test hasNext on an empty collection (returns false)
        test next() on an empty collection (throws exception)
        test hasNext on a collection with one item (returns true, several times)
        test hasNext/next on a collection with one item: hasNext returns true, next returns the item, hasNext returns false, twice
        test remove on that collection: check size is 0 after
        test remove again: exception
        final test with a collection with several items, make sure the iterator goes through each item, in the correct order (if there is one)
        remove all elements from the collection: collection is now empty
         */
        Object value;
        Iterator<?> iterator = i0.iterator();
        assertFalse(iterator.hasNext());
        try {
            iterator.next();
            fail("Empty iterator did not throw exception");
        } catch(Exception ex) { }
        
        
        iterator = i1.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        try{
            value = iterator.next();
            assertNotNull(value);
        } catch(Exception ex) {
            fail();
        }
        try {
            iterator.next();
            fail();
        } catch(Exception ex) { }
        
        iterator = i2.iterator();
        value = iterator.next();
        assertNotNull(value);
        assertEquals(value.toString(), Double.valueOf(0));
        
        value = iterator.next();        
        assertNotNull(value);
        assertEquals(value,1);
        
        value = iterator.next();
        assertNotNull(value);
        assertEquals(value,2);
        
        value = iterator.next();        
        assertNotNull(value);
        assertEquals(value,3);
        
        value = iterator.next();
        assertNotNull(value);
        assertEquals(value,4);
    }
}
