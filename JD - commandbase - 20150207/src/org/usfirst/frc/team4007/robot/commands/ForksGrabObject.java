package org.usfirst.frc.team4007.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Commande permettant de ramasser l'objet
 */
public class ForksGrabObject extends CommandGroup {
    
    public  ForksGrabObject() {
    	
    	ForksGotoGoal goingToGoal = new ForksGotoGoal();    	
    	
    	addSequential(new ForksSetToGrabWidth(goingToGoal));
    	addSequential(goingToGoal);
    }
}
