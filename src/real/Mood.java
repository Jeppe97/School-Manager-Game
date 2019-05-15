package real;

import java.awt.Color;
import java.awt.Graphics;

public class Mood extends GameObject{

	public Mood(int x, int y, ID id) {
		super(x, y, id);
		
		mood = 100;
		greenValue = 255;
	}

	public void tick() {
		mood = Game.clamp(mood, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = mood*2;
		mood--;
	
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(15, 15, mood*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
	}

}
