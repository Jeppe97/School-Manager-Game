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
	private HUD hud;
	BufferedImage img;

	public Menu(Game game, Handler handler)  {
		this.game = game;
		this.handler = handler;

	}

	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();


		if(game.gameState == STATE.Menu) {
			//Play Button
			if(mouseOver(mx, my, (Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 140), 200, 64)) {
				handler.addObject(new TopRow(200,200, ID.TopRow));
				handler.addObject(new Money(200,200,ID.Money));
				handler.addObject(new Students(200,200,ID.Students));
				handler.addObject(new Mood(200,200,ID.Mood));
				game.gameState = STATE.Office;
			}

			//Help Button
			if(mouseOver(mx,my,(Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 50), 200, 64)) {
				game.gameState = STATE.Help;
			}



			//Quit Button
			if(mouseOver(mx,my,(Game.WIDTH/2 - 100), (Game.HEIGHT/2 + 40), 200, 64)) {
				System.exit(1);
			}

		}
		//Back Button For Help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,Game.WIDTH/2,(Game.HEIGHT/2)+200,200,64)) {
				game.gameState = STATE.Menu;
				return;
			}
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



	public void render(Graphics g) throws IOException {
		if(game.gameState == STATE.Menu) {	

			Font header = new Font("Courier",1,50);
			Font buttonText = new Font("Courier",1,30);

			g.setFont(header);
			g.setColor(Color.WHITE);
			String headline = "School Manager Game";
			int widthHeader = g.getFontMetrics().stringWidth(headline);
			g.drawString(headline, Game.WIDTH/2 - (widthHeader/2), Game.HEIGHT/2 - 200);

			g.setFont(buttonText);
			String play = "Play";
			int widthPlay = g.getFontMetrics().stringWidth(play);
			g.drawRect((Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 140), 200, 64); // mellanrum 90 i y-led
			g.drawString(play, ((Game.WIDTH/2) - widthPlay/2), (Game.HEIGHT/2) - 100);

			g.drawRect((Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 50), 200, 64);
			String help = "Help";
			int widthHelp = g.getFontMetrics().stringWidth(play);
			g.drawString(help, (Game.WIDTH/2 - (widthHelp/2)), (Game.HEIGHT/2 - 10));

			g.drawRect((Game.WIDTH/2 - 100), (Game.HEIGHT/2 + 40), 200, 64);
			String quit = "Quit";
			int widthQuit = g.getFontMetrics().stringWidth(quit);
			g.drawString(quit, (Game.WIDTH/2 - (widthQuit/2)), (Game.HEIGHT/2 + 80));


		}

		else if(game.gameState == STATE.Help) {

			Font fnt = new Font("Monotype Corsiva",1,50);

			g.setFont(fnt);
			g.setColor(Color.WHITE);
			String help = "There is no help here, you have to trust your guts.";
			int widthQuit = g.getFontMetrics().stringWidth(help);
			g.drawString(help, Game.WIDTH/2 - (widthQuit/2), Game.HEIGHT/2-100);

			String back = "Back";
			int widthBack = g.getFontMetrics().stringWidth(back);
			g.drawRect((Game.WIDTH/2 - 150), (Game.HEIGHT/2 + 200), 300, 64);
			g.drawString(back, Game.WIDTH/2 - (widthBack /2), (Game.HEIGHT/2)+250);
		}

	}

}