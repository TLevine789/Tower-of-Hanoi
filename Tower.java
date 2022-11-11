package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * The Tower class extends the LinkedStack class and
 * overrides its push() method
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class Tower extends LinkedStack<Disk> 
{
    private Position position;
    
    /**
     * Creates a new Tower object
     * @param position The position of the Tower
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
    
    /**
     * Returns the position of the Tower
     * @return the position
     */
    public Position position()
    {
        return this.position;
    }
    
    /**
     * Adds a disk to the front of the Tower
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            if (this.isEmpty() || 
                this.peek().compareTo(disk) > 0)
            {
                super.push(disk);
            }
            else
            {
                throw new IllegalStateException();
            }
        }
    }
}
