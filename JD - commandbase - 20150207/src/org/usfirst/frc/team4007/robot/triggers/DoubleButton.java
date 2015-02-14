package org.usfirst.frc.team4007.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class DoubleButton extends Trigger {
	
	private Joystick joy;
	private int button1, button2;
	
	public DoubleButton(Joystick joy, int button1, int button2) {
		this.joy = joy;
		this.button1 = button1;
		this.button2 = button2;
	}	
    
    public boolean get() {
        return joy.getRawButton(button1) && joy.getRawButton(button2);
    }
}
