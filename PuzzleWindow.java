package towerofhanoi;

import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import cs2.Button;
import java.util.Observer;
import java.util.Observable;
import java.awt.Color;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * Creates the window where the Tower
 * of Hanoi problem will be solved
 * @author Tyler Levine
 * @version 10.19.2021
 *
 */
public class PuzzleWindow implements Observer
{
    private HanoiSolver game;
    private Window window;
    private Shape left;
    private Shape middle;
    private Shape right;
    public static int WIDTH_FACTOR;
    public static int DISK_GAP = 0;
    public static int DISK_HEIGHT = 10;
    private Button solveButton;
    
    /**
     * Creates a new PuzzleWindow object
     * @param game The HanoiSolver which will be used to
     * solve the problem
     */
    public PuzzleWindow(HanoiSolver game)
    {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        left = new Shape(150, 220, 10, 100, Color.GRAY);
        middle = new Shape(300, 220, 10, 100, Color.GRAY);
        right = new Shape(450, 220, 10, 100, Color.GRAY);
        Disk newDisk = null;
        for (int i = 0; i < this.game.disks(); i++)
        {
            newDisk = new Disk(15 * (this.game.disks() + 1 - i)+ 2);
            this.game.getTower(Position.LEFT).push(newDisk);
            window.addShape(this.game.getTower(Position.LEFT).peek());
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        
        this.solveButton = new Button("Solve");
        this.window.addButton(solveButton, WindowSide.SOUTH);
        this.solveButton.onClick(this);
    }
    
    /**
     * Pauses between disk movements
     */
    private void sleep() 
    {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
    
    /**
     * Supports the solve button with its method
     * @param button The solve button
     */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Moves the top disk of one tower to another
     * @param position The position of the Tower where
     * the disk should be moved from
     */
    private void moveDisk(Position position)
    {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole;
        switch (position)
        {
        case LEFT:
            currentPole=this.left;
            break;
        case MIDDLE:
            currentPole=this.middle;
            break;
        case RIGHT:
            currentPole=this.right;
            break;
        default:
            currentPole=this.left;
            break;
        }
        int x = currentPole.getX();
        int y = currentPole.getY() + 100 - (this.game.getTower(position).size() * 
            (DISK_HEIGHT + DISK_GAP));
        int width = currentDisk.getWidth();

        currentDisk.moveTo(x - (width - 10) / 2, y - (DISK_GAP));
    }
    
    /**
     * Updates the window after a disk is moved
     */
    public void update(Observable o, Object arg) 
    {
        if(arg.getClass() == Position.class)
        {
            moveDisk((Position)arg);
        }
        sleep();
    }
    
}
