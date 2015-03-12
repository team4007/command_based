package org.usfirst.frc.team4007.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sert a mettre a zero le robot
 */
public class SystemToZero extends CommandGroup {
    
    public  SystemToZero() {
    	addParallel(new ForksClose());
    	
    	addSequential(new LowerLift());
    	

    }
}
