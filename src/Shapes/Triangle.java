package Shapes;

import Constants.Symbols;

/**
 * Class for triangle shape.
 * 
 * @author Diana
 */
public class Triangle extends BasicShape {
	
	@Override
	public void innitialize(int ref, Point centerGrav) {
		symbol = Symbols.TRIANGLE_SYMBOL;
		startPoints = new Point[3];
		endPoints = new Point[3];
		
		startPoints[0] = new Point(centerGrav.getX(), 
				centerGrav.getY() - 2 * ref);
		startPoints[1] = new Point(centerGrav.getX() + ref, 
				centerGrav.getY() + ref);
		startPoints[2] = new Point(centerGrav.getX() - ref, 
				centerGrav.getY() + ref);
	}
}
