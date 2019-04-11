package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


import real.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();

	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();
		
		//Play Button
		if(mouseOver(mx, my, Game.WIDTH/2, 100, 200, 64)) {
			handler.addObject(new Money(200,200,ID.Money));
      handler.addObject(new Students(200,200,ID.Students));

			game.gameState = STATE.Game;
		}
		
		//Help Button
		if(mouseOver(mx,my,Game.WIDTH/2,200,200,64)) {
			game.gameState = STATE.Help;
		}
		//Back Button For Help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,Game.WIDTH/2,(Game.HEIGHT/2)+200,200,64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		//Quit Button
		if(mouseOver(mx,my,Game.WIDTH/2,300,200,64)) {
			System.exit(1);
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
		if(game.gameState == STATE.Menu) {
			BufferedImage img = null;
	//	img = ImageIO.read(new File("C:\\Users\\Ebba\\Pictures\\Saved Pictures\\ImageEncoded.png"));
	//	g.drawImage(img, 150, 100, null);

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
		}else if(game.gameState == STATE.Help) {
			Font fnt = new Font("arial",1,50);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", Game.WIDTH/2, Game.HEIGHT/2-100);
			
			g.drawRect(Game.WIDTH/2, (Game.HEIGHT/2)+200, 200, 64);
			g.drawString("Back", Game.WIDTH/2, (Game.HEIGHT/2)+240);
		}
		
	}

}
