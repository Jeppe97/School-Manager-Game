package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Mood extends GameObject{
	
	private int counter;

	public Mood(int x, int y, ID id) {
		super(x, y, id);
		
		mood = 50;
		greenValue = 255;
		counter=0;
	}

	public void tick() {
		counter++;
		mood = Game.clamp(mood, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = mood*2;
		if(GameObject.tables<(GameObject.student/2) || GameObject.groupRooms<(GameObject.student/4) || GameObject.parkingLots<(GameObject.student/8)) {
			if(counter>100) {
			mood-=2;
			counter=0;
			}
		}
		else if(GameObject.tables>=(GameObject.student/2) && GameObject.groupRooms<(GameObject.student/4) && GameObject.parkingLots<(GameObject.student/8)) {
			if(counter>100) {
			mood+=2;
			counter=0;
			}
		}
		else if(GameObject.student<100) {
			if(counter>100) {
				mood-=2;
				counter=0;
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(15, 15, mood*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
