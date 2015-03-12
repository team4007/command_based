package org.usfirst.frc.team4007.robot.subsystems;

import org.usfirst.frc.team4007.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forks extends Subsystem {
    public enum mode{NARROW, WIDE, CAN};
	private Talon motor;
    
    public DigitalInput narrowLimit;
    public DigitalInput wideLimit;
	public Encoder encoder;
	
	public static mode widthMode = mode.NARROW;
	
    private double closingSpeed = 0.75;
    private double openingSpeed = -0.75;
    
    private double openingOffset = 14.875;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Forks() {
    	super();
    	motor = new Talon(RobotMap.PWMforkMotor);
    	narrowLimit = new DigitalInput(RobotMap.IONarowL);
    	wideLimit = new DigitalInput(RobotMap.IOwideL);
		
    	encoder = new Encoder(RobotMap.IOForkEnco1,RobotMap.IOForkEnco2,false, EncodingType.k2X);
		// Configuration
    	//encoder.setMaxPeriod(0.1);
    	encoder.setMinRate(.008);
    	encoder.setDistancePerPulse(0.0041); // 1 tour = 5.625 pouces = 497 pulses
    	//encoder.setReverseDirection(true);
  		   		
  		// Demarrage
    	encoder.reset();
    }
    
	public int getEncoderRaw() {
		if (narrowLimit.get())
			encoder.reset();
		
		return encoder.getRaw();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void open() {
    	if(!isAtWideLimit())
    		motor.set(openingSpeed);
    	//System.out.println("Fork Raw data: "+Robot.oi.EncoderFork.getRaw());
    }
    
    public void close() {
    	if(!isAtNarrowLimit())
    		motor.set(closingSpeed);
    }
    
    public void stop() {
    	motor.stopMotor();
    }
    
	/**
	 * Retourne la distance du lift par rapport au sol.
	 * @return Distance en pouce
	 */
	public double getDistance() {
		double distance = openingOffset;
		
		distance = isAtNarrowLimit() ? openingOffset : encoder.getDistance() + openingOffset;
		
		return distance;
	}
    
    
    public boolean isAtNarrowLimit() {    	
    	if (narrowLimit.get())
    		encoder.reset();
    	
    	return narrowLimit.get();
    }
    
    public boolean isAtWideLimit() {
    	return wideLimit.get();
    }
    
    public static void setMode(mode m){
    	widthMode = m;
    }
    
    public static mode getMode(){
    	return widthMode;
    }
    
}

