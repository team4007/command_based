package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.subsystems.Forks;
import org.usfirst.frc.team4007.robot.subsystems.Forks.OpeningMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Commande qui indique la largeur de la prochaine execution
 */
public class ForksSetToGrabWidth extends Command {

	OpeningMode om;
	double goal = 0;
	ForksGotoGoal cmd;
	
    public ForksSetToGrabWidth(ForksGotoGoal command) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.forks);
    	
    	cmd = command;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	om = Forks.getMode();
    	
    	switch(om) {
    	case NARROW:
    		goal = 16;
    		break;
    	case WIDE:
    		goal = 26;
    		break;
    	case CAN:
    		goal = 18;
    		break;
    	}
    	
    	cmd.to(goal);
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
