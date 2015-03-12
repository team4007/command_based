package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLiftHeight extends Command {
	
	
	
	double current;
	double goal;
	double error;
	double seuil = 0.1;
	
	
    public SetLiftHeight(double height) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.lift);
    	
    	goal = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	current = Robot.lift.getDistance();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	current = Robot.lift.getDistance();
    	error = goal - current;
    	
    	if (error < 0) {
    		// Trop haut
    		Robot.lift.lower();
    	}
    	else {
    		// Trop bas
    		Robot.lift.raise();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println("Erreur = " + error);
        return Math.abs(error) < seuil;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
