package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PrintDebug extends Command {

	boolean run = false;
    public PrintDebug() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.lift);
    	//requires(Robot.forks);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	run = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	outputDebug();
    	run = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return run;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private void outputDebug(){
    	System.out.println("---------------Debug-----------------");
    	System.out.println("S1/Limit externe: " + Robot.forks.wideLimit.get());
    	System.out.println("S2/Limite interne: " + Robot.forks.narrowLimit.get());
    	System.out.println("S3/Limite haut: " + Robot.lift.haut.get());
    	System.out.println("S4/limit bas: " + Robot.lift.bas.get());
    	System.out.println("Encodeur fourches: " + Robot.forks.getEncoderRaw());
    	System.out.println("Fourches distance: " + Robot.forks.getDistance());
    	System.out.println("Encodeur lift: " + Robot.lift.getEncoderRaw());
    	System.out.println("Lift distance: " + Robot.lift.getDistance());
    	System.out.println("---------------Debug-----------------");
    	//SmartDashboard.putString("mode", "TATA");
    }
}
