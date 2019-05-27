package real;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class ParkingLots extends GameObject{

	
	public ParkingLots(int x, int y, ID id) {
		super(x, y, id);
		parkingLots = 17;
	}

	public void tick() {
		
		parkingLotsString = Integer.toString(parkingLots);
		
	}

	
	public void render(Graphics g) throws IOException {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	
	
	
	
}
