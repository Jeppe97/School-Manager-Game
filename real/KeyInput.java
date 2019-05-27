package real;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import real.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private Game game;
	private Projectile projectile = new Projectile(Minigame.player.getX(), Minigame.player.getY(), ID.PROJECTILE, handler);
	private boolean shift = false;
	private boolean[] keyDown = new boolean[4];

	public KeyInput(Handler handler) {
		this.handler = handler;

		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(Game.gameState == STATE.MINIGAME) {
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.PLAYER) {
					//Key events for player 1
					if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
					if(key == KeyEvent.VK_S) tempObject.setVelY(5);
					if(key == KeyEvent.VK_D) tempObject.setVelX(5);
					if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
					
					if(key == KeyEvent.VK_SHIFT) {
						shift = true;
					}
					if(shift) {
						if(key == KeyEvent.VK_W) tempObject.setVelY(-10);
						if(key == KeyEvent.VK_S) tempObject.setVelY(10);
						if(key == KeyEvent.VK_D) tempObject.setVelX(10);
						if(key == KeyEvent.VK_A) tempObject.setVelX(-10);
					}
					
					if(key == KeyEvent.VK_SPACE) {
						handler.addObject(new Projectile(Minigame.player.getX()+13, Minigame.player.getY(), ID.PROJECTILE, handler));
					}
				}
				if(tempObject.getId() == ID.PROJECTILE) {
					if(key == KeyEvent.VK_SPACE) tempObject.setVelY(-10);
				}
			}
		}
		if(Game.gameState != STATE.MENU || Game.gameState != STATE.HELP) {
			if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(Game.gameState == STATE.MINIGAME) {
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.PLAYER) {
					//Key events for player 1
					if(key == KeyEvent.VK_W) tempObject.setVelY(0);
					if(key == KeyEvent.VK_S) tempObject.setVelY(0);
					if(key == KeyEvent.VK_D) tempObject.setVelX(0);
					if(key == KeyEvent.VK_A) tempObject.setVelX(0);

					if(key == KeyEvent.VK_SHIFT) {
						shift = false;
					}
				}
			}
		}
	}


}
