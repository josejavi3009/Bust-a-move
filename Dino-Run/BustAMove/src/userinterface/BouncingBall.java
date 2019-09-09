package userinterface;

import java.awt.Graphics;

public class BouncingBall extends BouncingFigure {

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean rightBorderCollision(int screenLimit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leftBorderCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upperBorderCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lowerBorderCollision(int screenLimit) {
		// TODO Auto-generated method stub
		return false;
	}

}
