
package org.usfirst.frc.team4007.robot.subsystems;

import org.usfirst.frc.team4007.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends Subsystem {
    private Talon motor;
    
    private double raisingSpeed = -1.0;
    private double loweringSpeed = 1.0;
	public Encoder encoder;
	//1 pied = 1700
    public DigitalInput haut;
    public DigitalInput bas;           
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Lift() {
		super();
		motor = new Talon(6);
		haut = new DigitalInput(3);
		bas = new DigitalInput(4);
		LiveWindow.addSensor("Lift", "Main motor", (Talon) motor);


		
		encoder = new Encoder(7,8,true, EncodingType.k4X);
		// Configuration
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
  		   		
  		// Demarrage
		encoder.reset();
		
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void raise() {
		if(!isAtTop())
			motor.set(raisingSpeed);
		//System.out.println("Lift Raw data: "+Robot.oi.EncoderLift.getRaw());
	}
	
	public void lower() {
		if(!isAtBottom())
			motor.set(loweringSpeed);
	}
	
	public int getEncoderRaw() {
		return encoder.getRaw();
	}
	
	public void stop() {
		// On utilise des moteurs de vitre et pour les bloquer
		// il faut envoyer momentanement une impulsion inverse
		motor.set(-motor.get() * 0.25);
		motor.stopMotor();
	}
	
	public boolean isAtTop(){
		return haut.get();
	}
	
	public boolean isAtBottom(){
		return bas.get();
	}
}

