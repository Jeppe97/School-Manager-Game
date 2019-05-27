package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class Projectile extends GameObject {

	
	Handler handler;
	public boolean alive = true;
	
	public Projectile(int x, int y, ID id, Handler handler) {
		super(x,y,id);
		this.handler = handler;
	}

	public void tick() {
		y += velY;
		
		//y = Game.clamp(y, Game.HEIGHT, 60);
		System.out.println("y coordinate: " + y + " and x coordinate: " + x);
		
		if(y == 60)
			handler.removeObject(this);
		
		collision();
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.ENEMY) {
				if(getBounds().intersects(tempObject.getBounds())) {
					GameObject.money += 100;
					handler.removeObject(this);
				}
			}
		}
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 11);
	}

	public void render(Graphics g) throws IOException {
		g.setColor(Color.green);
		
		
		if(alive)
			g.fillRect(x, y, 5, 10);
		
		
		
	}

}
