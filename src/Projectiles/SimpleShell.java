package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;

/**
 * Class for SimpleShell projectiles.
 * 
 * @author Diana
 */
public class SimpleShell extends Projectile{
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shape = new Dot();
		this.ref -= dist / 10 + id;
		hitScreenAction(shooterPosition, ref);
	}

	@Override
	public void hitScreenAction(Point shooterPosition, int ref) {
		this.shape.draw(this.screen, ref, shooterPosition);
	}
}
