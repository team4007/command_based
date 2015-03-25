package org.usfirst.frc.team4007.robot.commands;

import java.util.ArrayList;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Line;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.Rect;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 */
public class UpdateCamera extends Command {
	
	 public void addCircle(int top, int left, int height, int width, float color) {
	    	Rect c = new Rect(top, left, height, width);
	    	cercles.add(c);
	    	cercleColor.add(color);
	    }
	 
	 public void addLine(int starty, int startx, int endy, int endx, float color){
	    	Point start = new Point(starty, startx);
	    	Point end = new Point(endy, endx);
	    	Line l = new Line(start, end);
	    	lignes.add(l);
	    	lineColor.add(color);
	 }
	 
    public UpdateCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	    
	    camera = new AxisCamera("10.40.7.30");
	    //camera.writeMaxFPS(8);
    	frame= NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	cercles = new ArrayList<Rect>();
    	lignes = new ArrayList<Line>();
    	cercleColor = new ArrayList<Float>();
    	lineColor = new ArrayList<Float>();
    }
    
    int session;
    Image frame;
    AxisCamera camera;
    String ip;
    
    ArrayList<Rect> cercles;
    ArrayList<Line> lignes;
    ArrayList<Float> cercleColor;
    ArrayList<Float> lineColor;
    // Called just before this Command runs the first time
    
    double timeAccumulator = 0;
    double refreshInterval = 0.250;
    double previousTime = 0;
    
    public void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	//Timer.delay(1);
    	
    	timeAccumulator += (timeSinceInitialized() - previousTime);
    	previousTime = timeSinceInitialized();
    	
    	if (timeAccumulator >= refreshInterval) {
    		timeAccumulator = 0;
    		
	    	if(camera.isFreshImage()){
	    		camera.getImage(frame);
	    	 
	    	 
	    		for (int i = 0; i < cercles.size(); i++) {
				
		    		 Rect c = cercles.get(i);
		    		 float co = cercleColor.get(i);	    		 
		    		 NIVision.imaqDrawShapeOnImage(frame, frame, c, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, co);
	    		}
		    	 
		         for(int i = 0; i < lignes.size(); i++){
					Line l = lignes.get(i);
					float co = lineColor.get(i);
					NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, l.start, l.end, co);
		         }
		         
		    	 CameraServer.getInstance().setImage(frame);
	    	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
