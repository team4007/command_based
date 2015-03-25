package org.usfirst.frc.team4007.robot.commands;

import org.usfirst.frc.team4007.robot.subsystems.Forks.OpeningMode;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabGarbaggeCan extends CommandGroup {
    
    public  GrabGarbaggeCan() {
    	addSequential(new LowerLift());
        addSequential(new ForksSetModeAutonomous(OpeningMode.GARBAGGE));
        addParallel(new ForksPrepareForGrabbing());
        addSequential(new RaiseLift(1.8));
        addSequential(new ForksGrabObject());
        addSequential(new RaiseLift(0.6));
        
    }
}
