package towerofhanoi;

import junit.framework.TestCase;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * Tests the Disk() class 
 * 
 * @author Tyler Levine
 * @version 10.19.2021
 * 
 */
public class DiskTest extends TestCase 
{
    private Disk disk1;
    private Disk disk2;
    
    /**
     * Sets up all test cases
     */
    public void setUp()
    {
        disk1 = new Disk(10);
        disk2 = new Disk(20);
    }
    
    /**
     * Tests the compareTo() method
     */
    public void testCompareTo()
    {
        assertEquals(10, disk2.compareTo(disk1));
    }
    
    /**
     * Tests the compareTo() method's exception
     */
    public void testCompareToException()
    {
        disk1 = null;
        Exception exception = null;
        try
        {
            disk2.compareTo(disk1);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        assertEquals("10", disk1.toString());
        assertEquals("20", disk2.toString());
    }
    
    /**
     * Tests the equals() method when the
     * disk has itself as a parameter
     */
    public void testEquals1()
    {
        assertTrue(disk1.equals(disk1));
    }
    
    /**
     * Tests the equals() method when the
     * disk has a null object as a parameter
     */
    public void testEquals2()
    {
        disk2 = null;
        assertFalse(disk1.equals(disk2));
    }
    
    /**
     * Tests the equals() method when the
     * disk has an equal disk as a parameter
     */
    public void testEquals3()
    {
        disk2 = new Disk(10);
        assertTrue(disk1.equals(disk2));
    }
    
    /**
     * Tests the equals() method when the
     * disk has a non-equal disk as a parameter
     */
    public void testEquals4()
    {
        assertFalse(disk1.equals(disk2));
    }
    
    /**
     * Tests the equals() method when the
     * disk has a non-disk object as a parameter
     */
    public void testEquals5()
    {
        Object object = new Object();
        assertFalse(disk1.equals(object));
    }
}
