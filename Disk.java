package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * The Disk() class extends the Shape() class
 * and implements Comparable. This class creates
 * a disk that can be compared to other disks.
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class Disk extends Shape implements Comparable<Disk> 
{
    /**
     * Creates a new Disk object of a desired width
     * @param width The desired width
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom generator = new TestableRandom();
        int color1 = generator.nextInt(256);
        int color2 = generator.nextInt(256);
        int color3 = generator.nextInt(256);
        this.setBackgroundColor(new Color(color1, color2, color3));
    }
    
    /**
     * Subtracts the width of the disk 
     * from the width of another disk
     * that is in the parameter and returns
     * the value
     * 
     * @param otherDisk The disk being subtracted
     * @return The difference
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        
        else
        {
            return (this.getWidth() - otherDisk.getWidth());
        }
    }
    
    /**
     * Returns a string of the disk's width
     * 
     * @return The string
     */
    public String toString()
    {
        return String.valueOf(this.getWidth());
    }
    
    /**
     * Returns if two disks have the same
     * widths as each other
     * 
     * @param obj The disk being compared
     * @return True if equal, False if not
     */
    public boolean equals(Object obj)
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) 
        {
            Disk otherDisk = (Disk) obj;
            if (this.getWidth() == otherDisk.getWidth())
            {
                return true;
            }
        }
        return false;
    }
}
