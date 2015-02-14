package org.usfirst.frc.team4007.robot.subsystems;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public Jaguar frontLeft;
	public Jaguar frontRight;
	public Jaguar rearLeft;
	public Jaguar rearRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//private RobotDrive drive;
    
    public DriveTrain() {
      	frontLeft = new Jaguar(4);
    	frontRight = new Jaguar(1);
    	rearLeft = new Jaguar(3);
    	rearRight = new Jaguar(2);
    	
    	/*
    	drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		drive.setSafetyEnabled(true);
		drive.setExpiration(0.1);
		drive.setSensitivity(0.5);
		drive.setMaxOutput(1.0);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	*/
    	
    	
    	
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(Joystick joystick) {
    	double LeftX = 0.0;
    	double LeftY = 0.0;
    	double RightX = 0.0;
    	double RightY = 0.0;
    	
		LeftX = joystick.getRawAxis(0)/2;
		LeftY = joystick.getRawAxis(1)/2;
		
		RightX = joystick.getRawAxis(4)/2;
		RightY = joystick.getRawAxis(5)/2;
		
		
		frontLeft.set(-LeftY + RightX + LeftX);
		frontRight.set(-(-LeftY - RightX - LeftX));
		
		rearLeft.set(-LeftY + RightX - LeftX);
		rearRight.set(-(-LeftY - RightX + LeftX));
		
//		frontLeft.set(.25);
//		frontRight.set(-.25);
//		
//		rearLeft.set(.25);
//		rearRight.set(-.25);
		
    }
    
    public void stop() {
    	frontLeft.stopMotor();
    	frontRight.stopMotor();
    	rearLeft.stopMotor();
    	rearRight.stopMotor();
    	
    }
}

