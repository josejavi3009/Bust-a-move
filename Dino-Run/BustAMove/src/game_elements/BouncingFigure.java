package game_elements;
import java.awt.Graphics;

import javax.swing.JComponent;

	/**
	 * A class that represents a figure that can bounce
	 * Note: This class doesn't have a constructor and it has abstract methods
	 */
public abstract class BouncingFigure {

	// Variables to contain some of the figure's properties
	private int xLeft = 0;
	private int yTop = 0;
	private int speed = 10;          // Speed in pixels per second
	private double trajectory = 0.0; // An trajectory angle in degrees 90 is vertical up, 0 is horizontal right

	// No constructors since will never create an object of this class

	// Getters
	public int getXLeft() {
		return this.xLeft;
	}

	public int getYTop() {
		return this.yTop;
	}

	public double getTrajectory() {
		return trajectory;
	}

	public int getSpeed() {
		return speed;
	}

	// Setters
	public void setXLeft(int xleft){
		this.xLeft=xleft;
	}

	public void setYTop(int ytop){
		this.yTop=ytop;
	}

	public void setTrajectory(double trajectory) {
		this.trajectory = trajectory;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// Instance methods
	/**
	 * move - protected method to be called from paintComponent() in the subclass
	 */
	protected void move() { 
		moveAtAngle(getTrajectory(),getSpeed());
		// Change trajectory upon collision with border
	}

	/**
	 * moveAtAngle - updates the new position of the figure
	 * @param angle - angle in which the figure moves to
	 * @param pixelsPerSec - speed in which the figure moves
	 */
	public void moveAtAngle(double angle,int pixelsPerSec){

		//Understand this method to answer Q1
		
		// Divide speed by 10 because frame is repainted every 0.1 sec
		int magnitude = Math.max(pixelsPerSec / 10,1);

		// Compute horizontal and vertical components of linear translation
		// 90 degrees trajectory -> move straight up. 
		// 0 degrees trajectory -> move horizontally to the right
		int xVector= (int) (magnitude*Math.cos(Math.toRadians(angle)));
		int yVector= -(int) (magnitude*Math.sin(Math.toRadians(angle))); 


		//current values, for debugging purposes
		System.out.println("Current (x,y) position and vectors values to be added or substracted");
		System.out.println("xVector=" +xVector);
		System.out.println("yVector=" +yVector);
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);

		//moving to the new coordinates by addition
		this.xLeft=this.xLeft+xVector;
		this.yTop=this.yTop+yVector;

		//new positions on the (x,y) plane for debugging purposes
		System.out.println("New (x,y) position with vectors values updated");
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);
	}
	
	// Abstract methods to be implemented by subclasses (Do Not Modify!)
	public abstract void draw(Graphics g);
	public abstract boolean rightBorderCollision(int screenLimit);
	public abstract boolean leftBorderCollision();
	public abstract boolean upperBorderCollision();
	public abstract boolean lowerBorderCollision(int screenLimit);
}
