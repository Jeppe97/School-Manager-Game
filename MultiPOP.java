package real;

import java.awt.Color;
import java.awt.Graphics;

public class MultiPOP extends GameObject {

	public MultiPOP(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(800, 500, 300, 700);
		
		
		
	}

}
