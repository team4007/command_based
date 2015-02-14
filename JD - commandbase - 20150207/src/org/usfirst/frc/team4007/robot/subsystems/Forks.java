package org.usfirst.frc.team4007.robot.subsystems;

import org.usfirst.frc.team4007.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forks extends Subsystem {
    private Talon motor;
    
    public DigitalInput narrowLimit;
    public DigitalInput wideLimit;
	public Encoder encoder;

    private double closingSpeed = 0.5;
    private double openingSpeed = -0.5;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Forks() {
    	super();
    	motor = new Talon(5);
    	narrowLimit = new DigitalInput(2);
    	wideLimit = new DigitalInput(1);
		
    	encoder = new Encoder(5,6,true, EncodingType.k4X);
		// Configuration
    	encoder.setMaxPeriod(0.1);
    	encoder.setMinRate(10);
    	encoder.setDistancePerPulse(5);
    	encoder.setReverseDirection(true);
  		   		
  		// Demarrage
    	encoder.reset();
    }
    
	public int getEncoderRaw() {
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
    
    
    public boolean isAtNarrowLimit() {
    	return narrowLimit.get();
    }
    
    public boolean isAtWideLimit() {
    	return wideLimit.get();
    }
}

