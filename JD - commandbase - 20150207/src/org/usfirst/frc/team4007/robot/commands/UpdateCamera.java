package org.usfirst.frc.team4007.robot.commands;

import java.util.ArrayList;

import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Line;
import com.ni.vision.NIVision.Rect;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 */
public class UpdateCamera extends Command {

    public UpdateCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	int session;
	    Image frame;
	    AxisCamera camera;
	    String ip;
	    
	    ArrayList<Rect> cercles;
	    ArrayList<Line> lignes;
	    ArrayList<Float> cercleColor;
	    ArrayList<Float> lineColor;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
