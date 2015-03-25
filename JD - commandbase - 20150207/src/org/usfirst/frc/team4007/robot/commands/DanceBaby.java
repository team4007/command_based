package org.usfirst.frc.team4007.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DanceBaby extends CommandGroup {
    
    public  DanceBaby() {
    	addSequential(new MoveForward(2.0));
    	addSequential(new StrafeRight(1.0));
    	addSequential(new MoveBackward(1.0));
    	addSequential(new StrafeLeft(1.0));
    }
}
