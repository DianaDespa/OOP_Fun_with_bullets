package Shapes;

import Constants.Symbols;

/**
 * Class for square shape.
 * 
 * @author Diana
 */
public class Square extends BasicShape {
	
	@Override
	public void innitialize(int ref, Point centerGrav) {
		symbol = Symbols.SQUARE_SYMBOL;
		startPoints = new Point[4];
		endPoints = new Point[4];
		
		startPoints[0] = new Point(centerGrav.getX() - ref, 
				centerGrav.getY() - ref);
		startPoints[1] = new Point(centerGrav.getX() + ref, 
				centerGrav.getY() - ref);
		startPoints[2] = new Point(centerGrav.getX() + ref, 
				centerGrav.getY() + ref);
		startPoints[3] = new Point(centerGrav.getX() - ref, 
				centerGrav.getY() + ref);
	}
}
