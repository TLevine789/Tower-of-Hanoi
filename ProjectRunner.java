package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

public class ProjectRunner 
{
    
    public static void main(String[] args) 
    {
        int disks = 6;
        if(args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(hanoi);
    }
    
    public ProjectRunner()
    {
    }
}
