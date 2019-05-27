package real;


import java.awt.Graphics;
import java.awt.Rectangle;

public class Office extends GameObject {

	public Office(int x, int y, ID id) {
		super(x, y, id);
	}

	
	public void tick() {
		//Is empty because we don't have anything that needs to tick in this class.
	}

	
	public void render(Graphics g) {
		g.fillRect(x, y, 32, 32);
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}