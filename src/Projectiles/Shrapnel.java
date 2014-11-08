package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Square;

/**
 * Class for Shrapnel projectiles.
 * 
 * @author Diana
 */
public class Shrapnel extends SpiderShot{

	public Shrapnel(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
		this.id = 5;
		this.shape = new Square();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX() +
				(int)Math.round(Math.sin(dist * Math.PI / 2)), 
				shooterPosition.getY());
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
