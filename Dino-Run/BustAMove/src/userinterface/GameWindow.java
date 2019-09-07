package userinterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	private GameScreen gameScreen;
	
	public GameWindow() {
		super("Java Bust-a-move");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen = new GameScreen();
		add(gameScreen);
		addKeyListener(gameScreen);
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
