package org.usfirst.frc.team4007.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4007.robot.commands.ForksClose;
import org.usfirst.frc.team4007.robot.commands.ForksGrabObject;
import org.usfirst.frc.team4007.robot.commands.ForksPrepareForGrabbing;
import org.usfirst.frc.team4007.robot.commands.ForksSetMode;
import org.usfirst.frc.team4007.robot.commands.ForksGotoGoal;
import org.usfirst.frc.team4007.robot.commands.PrintDebug;
import org.usfirst.frc.team4007.robot.commands.LowerLift;
import org.usfirst.frc.team4007.robot.commands.ForksOpen;
import org.usfirst.frc.team4007.robot.commands.RaiseLift;
import org.usfirst.frc.team4007.robot.commands.ResetEncoder;
import org.usfirst.frc.team4007.robot.commands.SetLiftHeight;
import org.usfirst.frc.team4007.robot.commands.StopForks;
import org.usfirst.frc.team4007.robot.commands.StopLift;
import org.usfirst.frc.team4007.robot.subsystems.Lift;
import org.usfirst.frc.team4007.robot.triggers.DPad;
import org.usfirst.frc.team4007.robot.triggers.DoubleButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	//SmartDashboard db = new SmartDashboard();
	
	public ForksGotoGoal forksGotoGoal;
	private ForksSetMode forksSetMode;
	
	public OI() {
		joystick = new Joystick(0);
		forksGotoGoal = new ForksGotoGoal(18);
		forksSetMode = new ForksSetMode();

		
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
		new DPad(joystick).whenActive(new ForksSetMode());
		
		jbA.whenActive(new LowerLift());
		jbA.whenInactive(new StopLift());
		
		jbX.whenActive(new RaiseLift());
		jbX.whenInactive(new StopLift());
		
		jbLB.whenActive(new ForksOpen());
		jbLB.whenInactive(new StopForks());
		
		jbRB.whenActive(new ForksClose());
		jbRB.whenInactive(new StopForks());		
		
		jbSTART.whenActive(new PrintDebug());
		
		
		jbBACK.whenActive(forksGotoGoal);
		
		jbY.whenActive(new ForksPrepareForGrabbing());
		jbB.whenActive(new ForksGrabObject());
		
		jbRS.whenActive(new SetLiftHeight(Lift.TOTE_PICKUP));
		
		
	}
	
}

