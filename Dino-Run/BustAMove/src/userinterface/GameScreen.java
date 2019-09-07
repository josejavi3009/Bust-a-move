package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScreen extends JPanel implements Runnable, KeyListener, ActionListener{
	
    private int deg = 0;
	private int i = 0;
	
	
	//angles for the bouncy bubbles
	private int x = 0, y = 0;
	private int angleX = 1, angleY = 1;
	
	private Thread thread;
	
	//Default position of bubble gun
	private int x1 = getWidth()/2 -10;
	private int x2 = getWidth()/2 +10;
	private int y1 = getHeight();
	private int y2 = getHeight()-70;
	
	//lines that make the bubble gun
	private Line2D line1 = new Line2D.Double(x1,y1, x1, y2);
	private Line2D line2 = new Line2D.Double(x2,y1, x2, y2);
	
	//the ball to shoot
	private Ellipse2D.Double ball = new Ellipse2D.Double(line1.getX1(), line1.getY2(), x2-x1, 20);

	private AffineTransform at1;
	private AffineTransform at2;

	Timer t = new Timer(5, this);
	private double velx, vely;

	
	public GameScreen() {
		thread = new Thread(this);
	}
	
	public void startGame() {
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
//			System.out.println(i++);
			try {
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.at1 = AffineTransform.getRotateInstance(Math.toRadians(deg), line1.getX1(), line1.getY1());
		this.at2 = AffineTransform.getRotateInstance(Math.toRadians(deg), line2.getX1(), line2.getY1());
		Shape sLine1 = this.at1.createTransformedShape(line1);
		Shape sLine2 = this.at1.createTransformedShape(line2);
		g2.draw(sLine1);
		g2.draw(sLine2);
	    this.ball.setFrame(x1, y1-10, x2-x1, 20);
	    g2.fill(this.ball);
	    g2.draw(this.ball);
	    
	}
	
	
	public void ballMove() {
		if(x + angleX < 0) {
			angleX = 1;
		}else if(x + angleX > getWidth() - 20) {
			angleX = -1;
		}else if(y + angleY < 0) {
			angleY = 1;
		}else if(y + angleY > getHeight() - 20) {
			angleY = -1;
		}
		
		x = x + angleX;
		y = y + angleY;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
    //	repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			left();
		}
		if(code == KeyEvent.VK_RIGHT) {
			right();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	public void right() {
		if(deg >=45) 
			deg = 45;
		else deg+=2;
//		this.ball.setFrame(line1.getX1(), line1.getY2(), x2-x1, 20);
	}
	public void left() {
		if(deg <= -45) 
			deg = -45;
		else deg-=2;
//		this.ball.setFrame(line1.getX1(), line1.getY2(), x2-x1, 20);
	}
}
