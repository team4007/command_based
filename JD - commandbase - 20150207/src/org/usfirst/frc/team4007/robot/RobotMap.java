package org.usfirst.frc.team4007.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;


	public static int PWMfrontRight = 1;
	public static int PWMfrontLeft = 4;
	public static int PWMrearRight = 2;
	public static int PWMrearLeft = 3;
	
	public static int PWMforkMotor = 5;
	public static int PWMliftMotor = 6;
	
	public static int IONarowL = 2;
	public static int IOwideL = 1;
	
	public static int IOHaut = 3;
	public static int IObas = 4;
	
	public static int IOLiftEnco1 = 7;
	public static int IOLiftEnco2 = 8;
	
	public static int IOForkEnco1 = 5;
	public static int IOForkEnco2 = 6;
}
