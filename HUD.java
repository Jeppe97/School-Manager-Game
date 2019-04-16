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
		if(mouseOver(mx, my, 250, Game.HEIGHT-150, 200, 50)) {

			game.gameState = STATE.Multisalen;
		}
		
		//Library Button
		if(mouseOver(mx,my,450, Game.HEIGHT-150, 200, 50)) {
			game.gameState = STATE.Canteen;
		}
		//Canteen Button  
			if(mouseOver(mx,my,650, Game.HEIGHT-150, 200, 50)) {

				game.gameState = STATE.Library;
			}
		
		//Parking lot Button
		if(mouseOver(mx,my,850, Game.HEIGHT-150, 200, 50)) {

			game.gameState = STATE.ParkingLot;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		 
	}	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	public void render(Graphics g) {
		
		
		Font fnt = new Font("Courier",1,20);
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		
		//Multisalen
		g.drawRect(250, Game.HEIGHT-150, 200, 50);
		g.drawString("MULTISALEN", 290, Game.HEIGHT-120);
		
		//Länken
		g.drawRect(450, Game.HEIGHT-150, 200, 50);
		g.drawString("CANTEEN", 500, Game.HEIGHT-120);
		
		//Biblan
		g.drawRect(650, Game.HEIGHT-150, 200, 50);
		g.drawString("LIBRARY", 700, Game.HEIGHT-120);
		
		//Parkering
		g.drawRect(850, Game.HEIGHT-150, 200, 50);
		g.drawString("PARKING LOT", 890, Game.HEIGHT-120);
		

		if(game.gameState == STATE.Multisalen) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to Multisalen!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.Canteen) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Canteen!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.Library) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Library!", 400, Game.HEIGHT/2);
		}
		if(game.gameState == STATE.ParkingLot) {
			Font fnt3 = new Font("Verdana",1,100);
			g.setFont(fnt3);
			g.drawString("Welcome to the Parking lot!", 400, Game.HEIGHT/2);
		}
		
	}
	
	
	

}