package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;

/**
 * Class for CanisterShot projectiles.
 * 
 * @author Diana
 */
public class CanisterShot extends HeatedShot{

	public CanisterShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
		this.id = 3;
		this.shape = new Rectangle();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX() - dist, 
				shooterPosition.getY());
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
