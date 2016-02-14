// Obstacles.java
// Andrew Davison, April 2005, ad@fivedots.coe.psu.ac.th
//Updated to new graphics standards by Roger Mailler, January 2009
/* A collection of boxes which the worm cannot move over
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Obstacles {
	private static final int BOX_LENGTH = 12;

	private ArrayList<Box> boxes; // arraylist of Rectangle objects
	private WormChase wormChase;

	public Obstacles(WormChase wc) {
		boxes = new ArrayList<Box>();
		wormChase = wc;
	}

	synchronized public void add(int x, int y, double wormX, double wormY) {
		boxes.add(new Box(x, y, BOX_LENGTH, BOX_LENGTH/*, wormX, wormY*/));
		wormChase.setBoxNumber(boxes.size()); // report new number of boxes
	}

	synchronized public void update()
	{
		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).update();
		}
	}


	synchronized public boolean hits(Point2D p, int size) {
		Box r = new Box( p.getX(), p.getY(), size, size);
		Box box;
		for (int i = 0; i < boxes.size(); i++) {
			box = boxes.get(i);
			if (box.intersects(r))
				return true;
		}
		return false;
	} // end of intersects()

	synchronized public void draw(Graphics g)
	// draw a series of blue boxes
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		for (int i = 0; i < boxes.size(); i++) {
			g2.fill(boxes.get(i).getRectangle());
		}
	} // end of draw()

	synchronized public int getNumObstacles() {
		return boxes.size();
	}

} // end of Obstacles class
