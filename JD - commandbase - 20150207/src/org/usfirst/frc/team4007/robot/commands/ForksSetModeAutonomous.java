package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.subsystems.Forks;
import org.usfirst.frc.team4007.robot.subsystems.Forks.OpeningMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ForksSetModeAutonomous extends Command {

	OpeningMode m;
	
    public ForksSetModeAutonomous(OpeningMode m) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.forks);
    	this.m = m;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Forks.setMode(m);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
