
package org.usfirst.frc.team4007.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4007.robot.Robot;

/**
 *
 */
public class RaiseLift extends Command {

    public RaiseLift() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.lift);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.raise();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lift.isAtTop();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
