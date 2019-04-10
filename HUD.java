package ver1;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	private static int Mood = 100;
	
	private int greenValue = 255;
	
	public void tick() {
		Mood = Game.clamp(Mood, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = Mood*2;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, Mood*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
	}
	
	
	
	
}
