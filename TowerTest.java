package towerofhanoi;

import junit.framework.TestCase;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * Tests the Tower class
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class TowerTest extends TestCase 
{
    private Tower tower;
    private Disk disk1;
    private Disk disk2;
    
    /**
     * Sets up all test cases
     */
    public void setUp()
    {
        tower = new Tower(Position.MIDDLE);
    }
    
    /**
     * Tests the position() method
     */
    public void testPosition()
    {
        assertEquals(Position.MIDDLE, tower.position());
    }
    
    /**
     * Tests the push() method
     */
    public void testPush()
    {
        disk1 = new Disk(10);
        disk2 = new Disk(5);
        tower.push(disk1);
        tower.push(disk2);
        assertEquals(2, tower.size());
    }
    
    /**
     * Tests the push() method's exception
     * for a null disk
     */
    public void testPushException1()
    {
        disk1 = new Disk(10);
        disk2 = null;
        tower.push(disk1);
        Exception exception = null;
        try
        {
            tower.push(disk2);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
    }
    
    /**
     * Tests the push() method's exception
     * for a larger disk
     */
    public void testPushException2()
    {
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        tower.push(disk1);
        Exception exception = null;
        try
        {
            tower.push(disk2);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception instanceof IllegalStateException);
    }
}
