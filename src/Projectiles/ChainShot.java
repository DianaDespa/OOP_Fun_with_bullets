package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Triangle;

/**
 * Class for ChainShot projectiles.
 * 
 * @author Diana
 */
public class ChainShot extends Shrapnel{

	public ChainShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
		this.id = 4;
		this.shape = new Triangle();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX(), 
				shooterPosition.getY() - dist);
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
