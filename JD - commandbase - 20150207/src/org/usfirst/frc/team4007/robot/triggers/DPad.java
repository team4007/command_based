package org.usfirst.frc.team4007.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class DPad extends Trigger {
    
	private Joystick joystick;
	
    public DPad(Joystick joystick) {
		super();
		this.joystick = joystick;
	}

	public boolean get() {
        return joystick.getPOV() >= 0;
    }
}
