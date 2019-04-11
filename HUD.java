package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import real.Game.STATE;

public class HUD extends MouseAdapter{

	private Game game;
	private Handler handler;
	
	private static int Mood = 100;
	private int greenValue = 255;
	
	public HUD(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();
		
		//Multisalen Button
		if(mouseOver(mx, my, 200, Game.HEIGHT-200, 200, 100)) {
			game.gameState = STATE.Multisalen;
		}
		
		//Library Button
		if(mouseOver(mx,my,500,Game.HEIGHT-200,200,100)) {
			game.gameState = STATE.Länken;
		}
		//Canteen Button  
			if(mouseOver(mx,my,800,Game.HEIGHT-200,200,100)) {
				game.gameState = STATE.Biblan;
			}
		
		//Parking lot Button
		if(mouseOver(mx,my,1100,Game.HEIGHT-200,200,100)) {
			game.gameState = STATE.Parkering;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		Mood--;
		Mood = Game.clamp(Mood, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = Mood*2;
	}	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	public void render(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(15, 15, Mood*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		Font fnt = new Font("Arial",1,30);
		g.setFont(fnt);
		//Multisalen
		g.drawRect(200, Game.HEIGHT-200, 200, 100);
		g.drawString("MULTISALEN", 200, Game.HEIGHT-160);
		//Länken
		g.drawRect(500, Game.HEIGHT-200, 200, 100);
		g.drawString("CANTEEN", 500, Game.HEIGHT-160);
		//Biblan
		g.drawRect(800, Game.HEIGHT-200, 200, 100);
		g.drawString("LIBRARY", 800, Game.HEIGHT-160);
		//Parkering
		g.drawRect(1100, Game.HEIGHT-200, 200, 100);
		g.drawString("PARKING LOT", 1100, Game.HEIGHT-160);
		if(game.gameState == STATE.Multisalen) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to Multisalen!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.Länken) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Canteen!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.Biblan) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Library!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.Parkering) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Parking lot!", 400, Game.HEIGHT/2);
		}
		
	}
	
	
	
	
}