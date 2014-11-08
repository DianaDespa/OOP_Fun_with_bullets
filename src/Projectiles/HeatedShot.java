package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Diamond;
import Shapes.Point;

/**
 * Class for HeatedShot projectiles.
 * 
 * @author Diana
 */
public class HeatedShot extends SpiderShot{

	public HeatedShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
		this.id = 6;
		this.shape = new Diamond();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX(), 
				shooterPosition.getY() +
				(int)Math.round(Math.cos(dist * Math.PI / 2)));
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}