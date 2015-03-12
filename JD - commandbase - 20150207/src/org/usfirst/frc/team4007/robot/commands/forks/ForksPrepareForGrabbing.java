package org.usfirst.frc.team4007.robot.commands.forks;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Commande permettant de preparer au ramassage de l'objet ou
 * de liberer l'objet
 */
public class ForksPrepareForGrabbing extends CommandGroup {
    
    public  ForksPrepareForGrabbing() {
    	
    	ForksGotoGoal goingToGoal = new ForksGotoGoal();    	
    	
    	addSequential(new ForksSetGrabbingWidth(goingToGoal));
    	addSequential(goingToGoal);
    }
}
