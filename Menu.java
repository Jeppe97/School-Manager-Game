package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


import real.Game.STATE;

public class Menu extends MouseAdapter{
	

	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu (Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void tick() {

	}

	public void render(Graphics g) {
		
		Font header = new Font("Courier",1,50);
		Font buttonText = new Font("Courier",1,30);

		g.setFont(header);
		g.setColor(Color.WHITE);
		g.drawString("School Manager Game", Game.WIDTH/2 - 300, Game.HEIGHT/2 - 200);

		g.setFont(buttonText);
		g.drawRect((Game.WIDTH/2 - 170), (Game.HEIGHT/2 - 140), 200, 64); // mellanrum 90 i y-led
		g.drawString("Play", (Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 100));

		g.drawRect((Game.WIDTH/2 - 170), (Game.HEIGHT/2 - 50), 200, 64);
		g.drawString("Help", (Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 10));

		g.drawRect((Game.WIDTH/2 - 170), (Game.HEIGHT/2 + 30), 200, 64);
		g.drawString("Quit", (Game.WIDTH/2 - 100), (Game.HEIGHT/2 + 70));
	}



}
