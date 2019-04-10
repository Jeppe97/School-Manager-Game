package real;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private static int Mood = 1000;
	
	public void tick() {
		
		
		Mood = Game.clamp(Mood, 0, 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, Mood*2, 32);
	}

}