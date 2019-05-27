package real;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class TopRow extends GameObject {

	public TopRow(int x, int y,ID id){
		super(x, y, id);
		
	}

	public void tick() {
		//Is empty because we don't need a tick in this class.
	}

	public void render(Graphics g) throws IOException {

		g.drawImage(ImageLoader.getImg("row"), 0, -20, null);
		
		g.drawImage(ImageLoader.getImg("desk"), 1865, 0, null);
		g.drawRect(1865, 0, 55, 55);
		
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
