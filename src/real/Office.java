package real;

import java.awt.Graphics;

public class Office extends GameObject {

	public Office(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
	
		g.fillRect(x, y, 32, 32);
	}

}
