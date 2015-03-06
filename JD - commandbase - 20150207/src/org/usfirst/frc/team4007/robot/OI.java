package org.usfirst.frc.team4007.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4007.robot.commands.CloseForks;
import org.usfirst.frc.team4007.robot.commands.ForksOpenTo;
import org.usfirst.frc.team4007.robot.commands.LiftGoto;
import org.usfirst.frc.team4007.robot.commands.PrintDebug;
import org.usfirst.frc.team4007.robot.commands.LowerLift;
import org.usfirst.frc.team4007.robot.commands.OpenForks;
import org.usfirst.frc.team4007.robot.commands.RaiseLift;
import org.usfirst.frc.team4007.robot.commands.ResetEncoder;
import org.usfirst.frc.team4007.robot.commands.StopForks;
import org.usfirst.frc.team4007.robot.commands.StopLift;
import org.usfirst.frc.team4007.robot.triggers.DoubleButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	

	
	public OI() {
		joystick = new Joystick(0);

		
		//xbox mapping
		JoystickButton jbA = new JoystickButton(joystick, 1),
				jbB = new JoystickButton(joystick, 2),
				jbX = new JoystickButton(joystick, 3),
				jbY = new JoystickButton(joystick, 4),
				jbLB = new JoystickButton(joystick, 5),
				jbRB = new JoystickButton(joystick, 6),
				jbBACK = new JoystickButton(joystick, 7),
				jbSTART = new JoystickButton(joystick, 8),
				jbLS = new JoystickButton(joystick, 9),
				jbRS = new JoystickButton(joystick, 10);
		
		new DoubleButton(joystick, 2, 4).whenActive(new ResetEncoder());
		
		jbA.whenActive(new LowerLift());
		jbA.whenInactive(new StopLift());
		
		jbX.whenActive(new RaiseLift());
		jbX.whenInactive(new StopLift());
		
		jbLB.whenActive(new OpenForks());
		jbLB.whenInactive(new StopForks());
		
		jbRB.whenActive(new CloseForks());
		jbRB.whenInactive(new StopForks());		
		
		jbSTART.whenActive(new PrintDebug());
		jbBACK.whenActive(new ForksOpenTo(18));
		
	}
    
}

