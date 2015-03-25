package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.subsystems.Forks;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Redimensionne la fourche a la bonne dimension
 */
public class ForksGotoGoal extends Command {
	
	double current;
	double goal;
	double error;
	double seuil = 0.1;
	
	double previousGoal;

    public ForksGotoGoal(double width) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.forks);
        
        goal = width;
    }
    
    public ForksGotoGoal() {
    	requires(Robot.forks);
    	
    	goal = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	current = Robot.forks.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	current = Robot.forks.getDistance();
    	error = goal - current;
    	
    	if (error < 0) {
    		// Trop large
    		Robot.forks.close();
    	}
    	else {
    		// Trop etroit
    		Robot.forks.open();
    	}
    	
    	//System.out.println("FORKS IS " + error + " TO GOAL");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean limitOn = false;
    	
    	if (Robot.forks.isClosing())
    		limitOn = Robot.forks.isAtNarrowLimit();
    	
    	if (Robot.forks.isOpening())
    		limitOn = Robot.forks.isAtWideLimit();

        return Math.abs(error) < seuil || goal == 0 || limitOn;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forks.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    public void to(double goal) {
    	this.goal = goal;
    	System.out.println("FORKS GOAL SET TO " + this.goal);
    }
    
    
}
