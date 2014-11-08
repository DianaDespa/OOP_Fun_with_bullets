import java.io.FileWriter;

import Constants.ProjectileNames;
import ProcessingManagers.TimeManager;
import Projectiles.CanisterShot;
import Projectiles.Carcass;
import Projectiles.ChainShot;
import Projectiles.HeatedShot;
import Projectiles.Projectile;
import Projectiles.Shrapnel;
import Projectiles.SimpleShell;
import Projectiles.SpiderShot;
import Projectiles.TriGrapeShot;
import Screen.Screen;

public class Main {

	public static void main(String[] args) throws Exception {
		FileParser fp = new FileParser(args[0]);
		
		/**
		 * Get general information from the file.
		 */
		int eX = fp.getEx();
		int eY = fp.getEy();
		Screen screen = new Screen(eX, eY);
		Projectile p = null;
		
		int nrProjectiles = fp.getNrProjectiles();
		for (int i = 0; i < nrProjectiles; i++) {
			/**
			 * Get information about each projectile.
			 */
			String projectileName = fp.getName();
			int ref = fp.getRef();
			TimeManager currentTime = fp.getTime();
			int dist = fp.getDist();
			Shapes.Point centerGrav = fp.getPoz();
			
			/**
			 * Identify projectile type.
			 */
			switch(projectileName) {
			case ProjectileNames.SIMPLE_SHELL:
				p = new SimpleShell(screen, ref, currentTime);
				break;
			case ProjectileNames.SPIDER_SHOT:
				p = new SpiderShot(screen, ref, currentTime);
				break;
			case ProjectileNames.SHRAPNEL:
				p = new Shrapnel(screen, ref, currentTime);
				break;
			case ProjectileNames.HEATED_SHOT:
				p = new HeatedShot(screen, ref, currentTime);
				break;
			case ProjectileNames.TRI_GRAPE_SHOT:
				p = new TriGrapeShot(screen, ref, currentTime);
				break;
			case ProjectileNames.CHAIN_SHOT:
				p = new ChainShot(screen, ref, currentTime);
				break;
			case ProjectileNames.CARCASS:
				p = new Carcass(screen, ref, currentTime);
				break;
			case ProjectileNames.CANNISTER_SHOT:
				p = new CanisterShot(screen, ref, currentTime);
				break;
			}
			
			p.shoot(dist, centerGrav); //launch projectile
		}

		/**
		 * Write the screen matrix to a new file, named like the input file,
		 * but with the "_out" suffix.
		 */
		FileWriter result = new FileWriter(args[0] + "_out");
		char[][]  matrix = screen.getScreen();
		for (int i = 0; i < eX; i++) {
			result.write(matrix[i]);
			result.append('\n');
		}
		result.close();	
	}
}
