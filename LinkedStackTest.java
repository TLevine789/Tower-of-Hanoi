package towerofhanoi;

import java.util.EmptyStackException;
import junit.framework.TestCase;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * Test class for LinkedStack class 
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class LinkedStackTest extends TestCase 
{
    private LinkedStack<String> linkStack;
    
    /**
     * Sets up all the test cases
     */
    public void setUp()
    {
        linkStack = new LinkedStack<String>();
    }
    
    /**
     * Tests the size() method
     */
    public void testSize()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        assertEquals(2, linkStack.size());
    }
    
    /**
     * Tests the isEmpty() method on
     * an empty stack
     */
    public void testIsEmpty1()
    {
        assertTrue(linkStack.isEmpty());
    }
    
    /**
     * Tests the isEmpty() method on
     * a non-empty stack
     */
    public void testIsEmpty2()
    {
        linkStack.push("hello");
        assertFalse(linkStack.isEmpty());
    }
    
    /**
     * Tests the clear() method
     */
    public void testClear()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        linkStack.clear();
        assertTrue(linkStack.isEmpty());
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString1()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        linkStack.push("Good");
        assertEquals("[Good, Yes, Hello]", linkStack.toString());
    }
    
    /**
     * Tests the toString() method
     * on an empty stack
     */
    public void testToString2()
    {
        assertEquals("[]", linkStack.toString());
    }
    
    /**
     * Tests the push() method
     */
    public void testPush()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        linkStack.push("Good");
        assertEquals(3, linkStack.size());
    }
    
    /**
     * Tests the peek() method
     */
    public void testPeek()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        linkStack.push("Good");
        assertEquals("Good", linkStack.peek());
    }
    
    /**
     * Tests the peek() method's exception
     */
    public void testPeekException()
    {
        Exception exception = null;
        try
        {
            linkStack.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
                   exception instanceof EmptyStackException);
    }
    
    /**
     * Tests the pop() method
     */
    public void testPop()
    {
        linkStack.push("Hello");
        linkStack.push("Yes");
        linkStack.push("Good");
        assertEquals("Good", linkStack.pop());
        assertEquals(2, linkStack.size());
    }
    
    /**
     * Tests the pop() method's exception
     */
    public void testPopException()
    {
        Exception exception = null;
        try
        {
            linkStack.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
                   exception instanceof EmptyStackException);
    }
}
