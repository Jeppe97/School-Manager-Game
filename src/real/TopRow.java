package real;

import java.awt.Graphics;
import java.io.IOException;

public class TopRow extends GameObject {

	public TopRow(int x, int y,ID id){
		super(x, y, id);
		
	}

	public void tick() {
		//Is empty because we don't need a tick in this class.
	}

	public void render(Graphics g) throws IOException {

		g.drawImage(ImageLoader.getImg(6), 0, -20, null);
		
		g.drawImage(ImageLoader.getImg(7), 1865, 0, null);
		g.drawRect(1865, 0, 55, 55);
		
	}
	
	
}
