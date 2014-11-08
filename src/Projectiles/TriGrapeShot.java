package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Triangle;

/**
 * Class for TriGrapeShot projectiles.
 * 
 * @author Diana
 */
public class TriGrapeShot extends Shrapnel{

	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	public void shoot(int dist, Point shooterPosition) {
		this.id = 1;
		this.shape = new Triangle();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX() + dist, 
				shooterPosition.getY());
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
