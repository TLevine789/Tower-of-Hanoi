package towerofhanoi;

import java.util.Observable;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * The HanoiSolver class has methods that help
 * it solve the Tower of Hanoi problem.
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class HanoiSolver extends Observable
{
    private Tower left = new Tower(Position.LEFT);
    private Tower middle = new Tower(Position.MIDDLE);
    private Tower right = new Tower(Position.RIGHT);
    private int numDisks;
    
    /**
     * Creates a new HanoiSolver object
     * @param numDisks The number of disks
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
    }
    
    /**
     * Returns the number of disks
     * @return number of disks
     */
    public int disks()
    {
        return numDisks;
    }
    
    /**
     * Returns the tower at the position
     * @param pos The position
     * @return The tower at said position
     */
    public Tower getTower(Position pos)
    {   
        if (pos == Position.RIGHT)
        {
            return right;
        }
        else if (pos == Position.LEFT)
        {
            return left;
        }
        else
        {
            return middle;
        }
    }
    
    /**
     * Returns a string of all three towers
     * 
     * @return The string
     */
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }
    
    /**
     * Moves a disk from one tower to another
     * @param source Starting Tower
     * @param destination Final Tower
     */
    private void move(Tower source, Tower destination)
    {
        Disk holder = source.pop();
        destination.push(holder);
        this.setChanged();
        this.notifyObservers(destination.position());
    }
    
    /**
     * Solves the Tower of Hanoi problem
     * @param currentDisks The current number of disks
     * @param startPole The starting pole where all disks start
     * @param tempPole  The temporary pole for holding disks
     * @param endPole   The final pole where the disks will be in order
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole)
    {
        if (currentDisks == 1)
        {
            this.move(startPole, endPole);
        }
        else if (currentDisks > 1)
        {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.solveTowers(1, startPole, tempPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Makes the initial call to the 
     * solveTowers() method
     */
    public void solve()
    {
        this.solveTowers(numDisks, left, middle, right);
    }
    
}
