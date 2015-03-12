package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.subsystems.Forks;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetForksWidth extends Command {
	
	double current;
	double goal;
	double error;
	double seuil = 0.05;
	
	double previousGoal;

    public SetForksWidth(double width) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.forks);
        
        goal = width;
    }
    
    public SetForksWidth(Forks.mode m){
    	requires(Robot.forks);
    	
    	switch (m) {
    	case NARROW:
    		goal = 18;
    		break;
    	case WIDE:
    		goal = 27;
    		break;
    	case CAN:
    		goal = 20;
    		break;
    	}
    	
    	System.out.println("FORKS OPENING TO " + goal);
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
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println("Erreur = " + error);
        return Math.abs(error) < seuil;
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
    
}
