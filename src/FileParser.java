
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.StringTokenizer;

import ProcessingManagers.TimeManager;
import Shapes.Point;

/**
 * Opens a file for reading and separates the input in tokens.
 * @author Diana
 */
public class FileParser {
	private StringTokenizer st = null;
	
	/**
	 * The constructor builds the string which will be split into tokens.
	 * @param file		the file to read from
	 */
	public FileParser(String file) throws Exception {
		InputStream inStream = null;
		BufferedInputStream bis = null;
		String str = "";
		
		try {
			// open input stream test.txt for reading purpose.
			inStream = new FileInputStream(file);
	
			// input stream is converted to buffered input stream
			bis = new BufferedInputStream(inStream);			
	
			// read until a single byte is available
			while(bis.available() > 0) {
				// read the byte and convert the integer to character
				char c = (char)bis.read();
				// form the entire string
				str += c; 
			}
			
			this.st = new StringTokenizer(str);
		
		} catch(Exception e) {
			// if any I/O error occurs
			e.printStackTrace();
		} finally {
			// releases any system resources associated with the stream
			if(inStream != null) {
				inStream.close();
			} 
			if(bis != null) {
				bis.close();
			}
		}
	}
	
	/**
	 * The following methods extract useful bits of text from the
	 * StringTokenizer: screen dimensions, number of projectiles, projectile
	 * name, reference, time, distance, position.
	 */
	
	public int getEx() {
		return Integer.valueOf(st.nextToken());
	}
	
	public int getEy() {
		return Integer.valueOf(st.nextToken());
	}
	
	public int getNrProjectiles() {
		return Integer.valueOf(st.nextToken());
	}
	
	public String getName() {
		return st.nextToken();
	}
	
	public int getRef() {
		return Integer.valueOf(st.nextToken());
	}
	
	public TimeManager getTime() {
		String aux = new String(st.nextToken());
		StringTokenizer auxSt = new StringTokenizer(aux, ":");
		int h = Integer.valueOf(auxSt.nextToken()),
			m =	Integer.valueOf(auxSt.nextToken()),
			s = Integer.valueOf(auxSt.nextToken());
		return new TimeManager(h, m, s);
	}
	
	public int getDist() {
		return Integer.valueOf(st.nextToken());
	}
	
	public Point getPoz() {
		int x = Integer.valueOf(st.nextToken()),
			y =	Integer.valueOf(st.nextToken());
		return new Point(x, y);
	}
}
