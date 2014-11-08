package Shapes;

import Constants.Symbols;

/**
 * Class for diamond shape.
 * 
 * @author Diana
 */
public class Diamond extends BasicShape {
	
	@Override
	public void innitialize(int ref, Point centerGrav) {
		symbol = Symbols.RHOMBUS_SYMBOL;
		startPoints = new Point[4];
		endPoints = new Point[4];
		
		startPoints[0] = new Point(centerGrav.getX(), 
				centerGrav.getY() - 2 * ref);
		startPoints[1] = new Point(centerGrav.getX() + ref, 
				centerGrav.getY());
		startPoints[2] = new Point(centerGrav.getX(), 
				centerGrav.getY() + 2 * ref);
		startPoints[3] = new Point(centerGrav.getX() - ref, 
				centerGrav.getY());
	}
}
