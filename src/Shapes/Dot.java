package Shapes;

import Constants.Symbols;

/**
 * Class for dot shape.
 * 
 * @author Diana
 */
public class Dot extends BasicShape {

	@Override
	public void innitialize(int ref, Point centerGrav) {
		symbol = Symbols.DOT_SYMBOL;
		startPoints = new Point[1];
		endPoints = new Point[1];
		startPoints[0] = centerGrav;
	}
	
}
