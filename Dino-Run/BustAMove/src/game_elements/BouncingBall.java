package game_elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class BouncingBall extends BouncingFigure {
	
	private int height;
	private int width;
	
	public BouncingBall(int xLeft, int yTop, int height, int width, double trajectory, int speed) {
		//Understand this constructor to answer Q2
		setXLeft(xLeft);
		setYTop(yTop);
		setTrajectory(trajectory);
		setSpeed(speed);
		this.height=height;
		this.width=width;
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(getYTop(), getXLeft(), this.height, this.width);
		g2.setColor(Color.RED);
		g2.fill(ball);
		g2.draw(ball);
		
	}

	@Override
	public boolean rightBorderCollision(int screenLimit) {
		if(getXLeft()+this.width > screenLimit)
			return true;
		return false;
	}

	@Override
	public boolean leftBorderCollision() {
		if(getXLeft() < 0)
			return true;
		return false;
	}

	@Override
	public boolean upperBorderCollision() {
		if(getYTop() < 0)
			return true;
		return false;
	}

	@Override
	public boolean lowerBorderCollision(int screenLimit) {
		if(getYTop()+this.height > screenLimit)
			return true;
		return false;
	}

}
