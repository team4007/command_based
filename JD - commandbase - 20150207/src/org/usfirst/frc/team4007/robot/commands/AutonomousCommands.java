package org.usfirst.frc.team4007.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommands extends CommandGroup {
    
    public  AutonomousCommands() {
        

//    	addSequential(new GrabGarbaggeCan());
//        addSequential(new MoveForward(2.0));
        addSequential(new SystemToZero());
//        addSequential(new MoveBackward(1.0));
    }
}
