
package org.usfirst.frc.team4007.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4007.robot.commands.AutonomousCommands;
import org.usfirst.frc.team4007.robot.commands.SystemToZero;
import org.usfirst.frc.team4007.robot.commands.UpdateCamera;
import org.usfirst.frc.team4007.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4007.robot.subsystems.Forks;
import org.usfirst.frc.team4007.robot.subsystems.Lift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Lift lift = new Lift();
	public static final Forks forks = new Forks();
	public static final DriveTrain driveTrain = new DriveTrain();
	//public static final UpdateCamera updateCamera = new UpdateCamera();
	public static OI oi;
	public static int encoderLift = 0;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new SystemToZero();
		autonomousCommand = new AutonomousCommands();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //updateCamera.start();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        encoderLift = Robot.lift.encoder.getRaw();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
