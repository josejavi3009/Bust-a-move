package userinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import game_elements.BouncingBall;
import game_elements.BouncingBox;
import game_elements.BouncingFigure;

public class GameWindow extends JFrame {
	private GameScreen gameScreen;
	
	public GameWindow() {
		
		int deg = 0;
		AffineTransform at1;
		AffineTransform at2;
		int x1 = this.getWidth() +190;
		int x2 = this.getWidth() +210;
		int y1 = 500;
		int y2 = 400;
		Line2D line1 = new Line2D.Double(x1,y1, x1, y2);
		Line2D line2 = new Line2D.Double(x2,y1, x2, y2);
		
		JFrame frame = new JFrame();
		frame.setTitle("Java Bust-a-move");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gameScreen = new GameScreen();
		//gameScreen.paintComponent(g, frame);
//		frame.add(gameScreen);
//		frame.addKeyListener(gameScreen);
		
		BouncingBox box = new BouncingBox();
		BouncingFigure ball = new BouncingBall(0, 0, 10, 10, 325.0, 100);
		box.add(ball);
		frame.add(box);
		frame.setVisible(true);
		at1 = AffineTransform.getRotateInstance(Math.toRadians(deg), line1.getX1(), line1.getY1());
		at2 = AffineTransform.getRotateInstance(Math.toRadians(deg), line2.getX1(), line2.getY1());
		Shape sLine1 = at1.createTransformedShape(line1);
		Shape sLine2 = at1.createTransformedShape(line2);
		
		//graphics must be elsewhere, check this
//		g2.draw(sLine1);
//		g2.draw(sLine2);
	//	setResizable(false);
		
		while(true) {
			try{
				Thread.sleep(100); // Wait for 0.1 seconds = 100 milliseconds
			}
			catch(InterruptedException e){}
			
			frame.repaint();
			}
		}

	
	public void startGame() {
		gameScreen.startGame();
	}
	public static void main(String args[]) {
		
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.startGame();
	}
	
}
