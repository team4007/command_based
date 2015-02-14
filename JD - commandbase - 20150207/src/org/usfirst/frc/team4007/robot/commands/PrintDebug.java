package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PrintDebug extends Command {

	private boolean run = false;
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
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return run;
    }

    // Called once after isFinished returns true
    protected void end() {
    	run = false;
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
    	System.out.println("Encodeur fourche: " + Robot.forks.encoder.getRaw());
    	System.out.println("Encodeur lift: " + Robot.lift.encoder.getRaw());
    	System.out.println("---------------Debug-----------------");
    }
}
