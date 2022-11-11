package towerofhanoi;

import junit.framework.TestCase;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * Tests the HanoiSolver class
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class HanoiSolverTest extends TestCase 
{
    private HanoiSolver game;
    
    /**
     * Sets up all test cases
     */
    public void setUp()
    {
        game = new HanoiSolver(5);
    }
    
    /**
     * Tests the disks() method
     */
    public void testDisks()
    {
        assertEquals(5, game.disks());
    }
    
    /**
     * Tests the getTower() method
     */
    public void testGetTower()
    {
        game.getTower(Position.LEFT).push(new Disk(5));
        game.getTower(Position.MIDDLE).push(new Disk(10));
        game.getTower(Position.RIGHT).push(new Disk(20));
        
        assertEquals("[5]", game.getTower(Position.LEFT).toString());
        assertEquals("[10]", game.getTower(Position.MIDDLE).toString());
        assertEquals("[20]", game.getTower(Position.RIGHT).toString());
        assertEquals("[10]", game.getTower(Position.DEFAULT).toString());
    }
    
    
    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        game.getTower(Position.LEFT).push(new Disk(5));
        game.getTower(Position.MIDDLE).push(new Disk(10));
        game.getTower(Position.RIGHT).push(new Disk(20));
        assertEquals("[5][10][20]", game.toString());
        game.getTower(Position.LEFT).pop();
        game.getTower(Position.MIDDLE).pop();
        game.getTower(Position.RIGHT).pop();
    }
    
    /**
     * Tests the solve() method
     */
    public void testSolve1()
    {
        game.getTower(Position.LEFT).push(new Disk(30));
        game.getTower(Position.LEFT).push(new Disk(25));
        game.getTower(Position.LEFT).push(new Disk(20));
        game.getTower(Position.LEFT).push(new Disk(10));
        game.getTower(Position.LEFT).push(new Disk(5));
        game.solve();
        assertEquals("[5, 10, 20, 25, 30]", 
            game.getTower(Position.RIGHT).toString());
        for (int i = 0; i < 5; i++)
        {
            game.getTower(Position.RIGHT).pop();
        }
    }
    
    /**
     * Tests the solve() method when there
     * are no disks
     */
    public void testSolve2()
    {
        HanoiSolver game1 = new HanoiSolver(0);
        game1.solve();
        assertEquals("[][][]", game1.toString());
    }
    
    
}
