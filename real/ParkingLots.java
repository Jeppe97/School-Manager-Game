package real;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class ParkingLots extends GameObject{

	
	public ParkingLots(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		parkingLots = 500;
	}

	public void tick() {
		
		parkingLotsString = Integer.toString(parkingLots);
		
	}

	
	public void render(Graphics g) throws IOException {
		// TODO Auto-generated method stub
		
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
