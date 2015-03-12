
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
	/**
	 * CONSTANTES DE HAUTEUR
	 */
	
	public static final float TOTE_PICKUP = 10;
	public static final float TOTE_MOVE = 15;
	public static final float TOTE_LIFT_OVER = 24;
	public static final float TOTE_DROP_OVER = 18;
	public static final float TOTE_DROP_GROUND = 10;
	
	
    private Talon motor;
    
    private double raisingSpeed = -1.0;
    private double loweringSpeed = .75;
	public Encoder encoder;
	//1 pied = 1700
    public DigitalInput haut;
    public DigitalInput bas;           
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private double groundOffset = 5.125; // Distance des fourches du sol

    public Lift() {
		super();
		motor = new Talon(6);
		haut = new DigitalInput(3);
		bas = new DigitalInput(4);
		LiveWindow.addSensor("Lift", "Main motor", (Talon) motor);


		
		encoder = new Encoder(7,8,true, EncodingType.k2X);
		// Configuration
		//encoder.setMaxPeriod(0.1);
		encoder.setMinRate(.15);
		//encoder.setDistancePerPulse(0.088889); // Sur bon robot
		encoder.setDistancePerPulse(0.0779); // Sur junior
		
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
		if (bas.get()) {
			encoder.reset();
		}		
		return encoder.getRaw();
	}
	
	/**
	 * Retourne la distance du lift par rapport au sol.
	 * @return Distance en pouce
	 */
	public double getDistance() {
		double distance = groundOffset;
		
		distance = isAtBottom() ? groundOffset : encoder.getDistance() + groundOffset;
		
		return distance;
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
		if (bas.get()) {
			encoder.reset();
		}
		return bas.get();
	}
}

