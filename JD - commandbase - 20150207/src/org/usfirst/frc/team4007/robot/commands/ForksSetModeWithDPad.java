package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.subsystems.Forks;
import org.usfirst.frc.team4007.robot.subsystems.Forks.OpeningMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ForksSetModeWithDPad extends Command {

    public ForksSetModeWithDPad() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.forks);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int dpad = Robot.oi.joystick.getPOV();
        
        switch (dpad) {
        	case 0:
        		Forks.setMode(OpeningMode.GARBAGGE);
        		System.out.println("FORKS SET TO CAN MODE");
        		SmartDashboard.putString("Forks_mode", "FORKS SET TO CAN MODE");
        		break;
        	case 90:
        		Forks.setMode(OpeningMode.WIDE);
        		System.out.println("FORKS SET TO WIDE MODE");
        		SmartDashboard.putString("Forks_mode", "FORKS SET TO WIDE MODE");
        		break;
        	case 270:
        		Forks.setMode(OpeningMode.NARROW);
        		System.out.println("FORKS SET TO NARROW MODE");
        		SmartDashboard.putString("Forks_mode", "FORKS SET TO NARROW MODE");
        		break;
        }
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
