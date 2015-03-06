package org.usfirst.frc.team4007.robot.subsystems;

import org.usfirst.frc.team4007.robot.Robot;
import org.usfirst.frc.team4007.robot.RobotMap;
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
      	frontLeft = new Jaguar(RobotMap.PWMfrontLeft);
    	frontRight = new Jaguar(RobotMap.PWMfrontRight);
    	rearLeft = new Jaguar(RobotMap.PWMrearLeft);
    	rearRight = new Jaguar(RobotMap.PWMrearRight);
    	
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
    	
    	double flValue, frValue, rlValue, rrValue;
  
		LeftX = joystick.getRawAxis(0);
		LeftY = joystick.getRawAxis(1);
		
		RightX = joystick.getRawAxis(4);
		RightY = joystick.getRawAxis(5);

		
/*		LeftX = joystick.getRawAxis(0)/2;
		LeftY = joystick.getRawAxis(1)/2;
		
		RightX = joystick.getRawAxis(4)/2;
		RightY = joystick.getRawAxis(5)/2;
	*/	
		
		flValue = -LeftY + RightX + LeftX;
		frValue = -(-LeftY - RightX - LeftX);
		
		rlValue = -LeftY + RightX - LeftX;
		rrValue = -(-LeftY - RightX + LeftX);
		
		flValue = Math.abs(flValue) < 0.3 ? 0 : flValue;
		frValue = Math.abs(frValue) < 0.3 ? 0 : frValue;
		rlValue = Math.abs(rlValue) < 0.3 ? 0 : rlValue;
		rrValue = Math.abs(rrValue) < 0.3 ? 0 : rrValue;
		
		frontLeft.set(flValue);
		frontRight.set(frValue);		
		rearLeft.set(rlValue);
		rearRight.set(rrValue);
		
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

