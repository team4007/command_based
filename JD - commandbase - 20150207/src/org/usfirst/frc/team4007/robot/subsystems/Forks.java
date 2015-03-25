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
    public enum OpeningMode{NARROW, WIDE, GARBAGGE};
	private Talon motor;
    
    public DigitalInput narrowLimit;
    public DigitalInput wideLimit;
	public Encoder encoder;
	
	public static OpeningMode widthMode = OpeningMode.NARROW;
	
    private double closingSpeed = 1.0;
    private double openingSpeed = -1;
    
    private double openingOffset = 14.60;
    private double maxOpening = 28.25;
    
    private boolean fromOutside = false; // Indique si la distance est calculee de l'exterieur.
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // Valeur maximale de l<encodeur est environ 6625 - 6650.
    
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
    
    public boolean isClosing() {
    	return motor.getSpeed() > 0;
    }
    
    public boolean isOpening() {
    	return motor.getSpeed() < 0;
    }
    
    public void stop() {
    	motor.stopMotor();
    }
    
	/**
	 * Retourne la distance du lift par rapport au sol.
	 * @return Distance en pouce
	 */
	public double getDistance() {
		double distance = 0;
		
		//distance = isAtNarrowLimit() ? openingOffset : encoder.getDistance() + openingOffset;
		
		if (isAtNarrowLimit()) {
			distance = openingOffset;
		} else if (isAtWideLimit()) {
			distance = maxOpening;
		} else if (fromOutside) {
			distance = maxOpening + encoder.getDistance();
			//System.out.println(distance);
		} else
			distance = encoder.getDistance() + openingOffset;
		
		return distance;
	}
    
    
    public boolean isAtNarrowLimit() {    	
    	if (narrowLimit.get()) {
    		encoder.reset();
    		fromOutside = false;
    	}
    	
    	return narrowLimit.get();
    }
    
    public boolean isAtWideLimit() {
    	if (wideLimit.get()){
    		fromOutside = true;
    		encoder.reset();
    	}
    	
    	return wideLimit.get();
    }
    
    public static void setMode(OpeningMode m){
    	widthMode = m;
    }
    
    public static OpeningMode getMode(){
    	return widthMode;
    }
    
}

