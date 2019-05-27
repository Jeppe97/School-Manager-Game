package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class BasicEnemy extends GameObject {

	Handler handler;
	boolean alive = true;


	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velY = 1;
	}

	public void tick() {
		// TODO Auto-generated method stub
		y += velY;
		
		collision();
		
		if(y == 800-32) {
			handler.removeObject(this);
			//alive = false;
		}

	}

	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.PROJECTILE) {
				if(getBounds().intersects(tempObject.getBounds())) {
					GameObject.money += 100;
					handler.removeObject(this);
					
				}
			}
		}
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void render(Graphics g) throws IOException {

		if(alive) {
			g.setColor(Color.red);
			g.drawImage(ImageLoader.getImg("moneyEnemy"), x, y, null);
			g.drawRect(x, y, 32, 32);	
		}

	}

	public void destroy() {
		handler.removeObject(this);
	}
	
}
