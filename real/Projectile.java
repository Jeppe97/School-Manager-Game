package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class Projectile extends GameObject {

	
	Handler handler;
	public boolean alive = true;
	boolean touched = false;
	int counter = 0;
	
	public Projectile(int x, int y, ID id, Handler handler) {
		super(x,y,id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}

	public void tick() {
		y += velY;
		
		if(y == 60)
			handler.removeObject(this);
		
		if(touched) {
			counter++;
			if(counter == 2) {
				handler.removeObject(this);
				counter = 0;
				touched = false;
			
			}
		}
			
		
			
		collision();
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.ENEMY) {
				if(getBounds().intersects(tempObject.getBounds())) {
					touched = true;
					
				}
			}
		}
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 10);
	}

	public void render(Graphics g) throws IOException {
		g.setColor(Color.green);
		
		
		if(alive)
			g.fillRect(x, y, 5, 10);
		
		
		
	}

	public void destroy() {
		handler.removeObject(this);
	}
	
}
