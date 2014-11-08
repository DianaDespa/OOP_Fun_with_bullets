package ProcessingManagers;

/**
 * Time object
 */
public class TimeManager {
	private int h, m, s;
	
	public TimeManager(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}
	
	public int getH() {
		return h;
	}
	
	public int getM() {
		return m;
	}
	
	public int getS() {
		return s;
	}
}