package real;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Tables extends GameObject{

	public Tables(int x, int y, ID id) {
		super(x, y, id);
		
		tables=500;
	}
	public void tick() {
	}

	
	public void render(Graphics g) throws IOException {
		g.setColor(Color.green);
		g.drawRect(10, 10, 100, 100);
	}

}
