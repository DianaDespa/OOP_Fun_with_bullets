package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * Class that defines the general behavior of a shape.
 */
public abstract class BasicShape {
	protected Point[] startPoints = null;
	protected Point[] endPoints = null;
	protected char symbol = Symbols.SCREEN_SYMBOL;
	
	/**
	 * Assigns the corresponding symbol to the shape and creates the
	 * startPoints array.
	 * 
	 * @param ref			reference distance
	 * @param centerGrav	gravity center of the shape
	 */
	public abstract void innitialize(int ref, Point centerGrav);
	
	/**
	 * Draws the current shape on the given screen
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, Point centerGrav) {
		innitialize(ref, centerGrav);
		assignEndPoints();
		screen.drawMultipleLinesOnScreen(startPoints , endPoints, symbol);
	}
	
	/**
	 * Creates the endPoints array by shifting the startPoints array by one
	 * element to the right.
	 */
	public void assignEndPoints() {
		endPoints[0] = startPoints[startPoints.length - 1];
		for (int i = 0; i < startPoints.length - 1; i++) {
			endPoints[i + 1] = startPoints[i];
		}
	}
}
