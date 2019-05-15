package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import real.Game.STATE;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	BufferedImage img;

	public Menu(Game game, Handler handler)  {
		this.game = game;
		this.handler = handler;

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();


		if(game.gameState == STATE.MENU) {
			//Play Button
			if(mouseOver(mx, my, (Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 140), 200, 64)) {
				handler.addObject(new TopRow(200,200, ID.TOPROW));
				handler.addObject(new Money(200,200,ID.MONEY));
				handler.addObject(new Students(200,200,ID.STUDENTS));
				handler.addObject(new Mood(200,200,ID.MOOD));
				game.gameState = STATE.OFFICE;
			}

			//Help Button
			if(mouseOver(mx,my,(Game.WIDTH/2 - 100), (Game.HEIGHT/2 - 50), 200, 64)) {
				game.gameState = STATE.HELP;
			}



			//Quit Button
			if(mouseOver(mx,my,(Game.WIDTH/2 - 100), (Game.HEIGHT/2 + 40), 200, 64)) {
				System.exit(1);
			}

		}
		//Back Button For Help
			if(game.gameState == STATE.HELP && mouseOver(mx,my,Game.WIDTH/2,(Game.HEIGHT/2)+200,200,64)) {
				game.gameState = STATE.MENU;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Do nothing because we don't use mouseReleased events in this class.
	}

	public void tick() {
		// Do nothing because we don't tick anything in this class.
	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}



	public void render(Graphics g) {
		if(game.gameState == STATE.MENU) {	
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

		else if(game.gameState == STATE.HELP) {

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
