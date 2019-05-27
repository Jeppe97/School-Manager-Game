package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class Player extends GameObject{

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 480, 1440-32);
		y = Game.clamp(y, 800, Game.HEIGHT-154);
	}

	public void render(Graphics g) throws IOException {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
