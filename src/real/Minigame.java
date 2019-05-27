package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Minigame {
	
	Handler handler;
	int counter = 400;
	int spawnCounter = 0;
	boolean playeradded = false;
	boolean enemySpawned = true;
	int Score;
	static Player player = new Player(960, Game.HEIGHT-182, ID.PLAYER);
	
	public Minigame(Handler handler) {
		this.handler = handler;
	
	}
	
	
	public void tick() {
		
		if(spawnCounter == 600) {
			enemySpawned = true;
		}
		if(enemySpawned) {
			handler.addObject(new BasicEnemy(800, 60, ID.ENEMY, handler));
			enemySpawned = false;
		}
		
		Score++;
		
		//if(counter == 400)
			//Game.gameState = Game.STATE.OFFICE;
		//counter--;

		
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(480, 60, 960, Game.HEIGHT-182);
		g.drawLine(480, 800, 1440, 800);
		
		if(!playeradded) {
			handler.addObject(player);
			playeradded = true;
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Score: "+ Score, 25,350);
		g.drawString("Shooting F:s give you a boost in mood", 25,380);
		g.drawString("Shooting Dollar-signs give you a boost in cash", 25,410);
		g.drawString("Control player with WASD", 25,440);
		g.drawString("Shoot with SPACE and boost with SHIFT", 25,470);

		
		
	}
	
}
