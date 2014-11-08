package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;

/**
 * Class for SpiderShot projectiles.
 * 
 * @author Diana
 */
public class SpiderShot extends SimpleShell{

	public SpiderShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	public void shoot(int dist, Point shooterPosition) {
		this.id = 7;
		this.shape = new Rectangle();
		this.shapeChangingDist = calculateDist();
		
		int diff = dist - this.shapeChangingDist;
		
		if (diff >= 0) {
			dist = this.shapeChangingDist;
		}
		this.ref -= dist / 10 + this.id;
		shooterPosition = new Point(shooterPosition.getX() +
				(int)Math.round(Math.sin(dist * Math.PI / 2)),
				shooterPosition.getY() +
				(int)Math.round(Math.cos(dist * Math.PI / 2)));
		if (diff >= 0) {
			super.shoot(diff, shooterPosition);
		} else {
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
