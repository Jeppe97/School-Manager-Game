package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Minigame {
	
	Handler handler;
	int counter = 400;
	int spawnCounter = 0;
	boolean playeradded = false;
	boolean enemySpawned = true;
	int Timer = 1500;
	int gameOverTimer = 0;
	int cooldown = 0;
	int xPos;
	int enemySelector;
	static Player player = new Player(960, Game.HEIGHT-182, ID.PLAYER);
	Random rn = new Random();
	Random rn2 = new Random();
	
	
	public Minigame(Handler handler) {
		this.handler = handler;
	
	}
	
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int decrease) {
		this.cooldown -= decrease;
	}
	
	public void tick() {
		
		xPos = rn.nextInt(1440-460+1) + 460;
		enemySelector = rn.nextInt(100) + 1;
		
		spawnCounter++;
		if(spawnCounter == 300) {
			enemySpawned = true;
			spawnCounter = 0;
		}
		if(enemySelector >= 50) {
			if(enemySpawned) {
				handler.addObject(new BasicEnemy(xPos, 60, ID.ENEMY, handler));
				enemySpawned = false;
			}
		}
		else if(enemySelector < 50) {
			if(enemySpawned) {
				handler.addObject(new MoodEnemy(xPos, 60, ID.ENEMY, handler));
				enemySpawned = false;
			}
		}
		
		Timer--;
		if(gameOverTimer > 1000) {
			reset();
			Game.gameState = Game.STATE.OFFICE;
		}
		
		Timer = Game.clamp(Timer, 0, 1500);
		//if(counter == 400)
			//Game.gameState = Game.STATE.OFFICE;
		//counter--;

		
	}
	
	public void reset() {
		Timer = 1500;
		cooldown = 15000;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.ENEMY || tempObject.getId() == ID.PLAYER || tempObject.getId() == ID.PROJECTILE) {
				tempObject.destroy();
			}
		}
		gameOverTimer = 0;
		
		
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
		g.drawString("Time left: "+ Timer, 25,350);
		g.drawString("Shooting F:s give you a boost in mood", 25,380);
		g.drawString("Shooting Dollar-signs give you a boost in cash", 25,410);
		g.drawString("Control player with WASD", 25,440);
		g.drawString("Shoot with SPACE and boost with SHIFT", 25,470);

		if(Timer == 0) {
			
			g.fillRect(Game.WIDTH/2-200, Game.HEIGHT/2-75, 400, 150);
			g.setColor(Color.black);
			g.drawString("Good job! Going to Office...", Game.WIDTH/2-180, Game.HEIGHT/2+5);
			gameOverTimer++;
		}
		
	}
	
}
