package real;

import java.awt.Graphics;
import java.io.IOException;

public class Tables extends GameObject{

	public Tables(int x, int y, ID id) {
		super(x, y, id);
		
		tables=500;
	}
	public void tick() {
		//Is empty because we don't need a tick in this class.
		tableString = Integer.toString(tables);
	}

	
	public void render(Graphics g) throws IOException {
		
	}

}
