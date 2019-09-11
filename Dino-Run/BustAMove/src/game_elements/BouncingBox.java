package game_elements;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * A class that act as a container for all the added figures
 * Note: This is a dynamic class without a constructor
 */
public class BouncingBox extends JComponent {

	//ArrayList containing all the added figures
	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	/**
	 * add - A method that adds a new figure to the list
	 * @param f - the figure to be added
	 */
	public void add(BouncingFigure f) {
		figures.add(f);
	}

	/**
	 * paintComponent - a method to initialize the drawing of each figure added
	 * @param g - the graphics to draw 
	 */
	public void paintComponent(Graphics g) {
		for (BouncingFigure f : figures) {
			f.draw(g); f.move();
		}
	}
}
