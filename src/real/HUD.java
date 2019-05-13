package real;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import real.Game.STATE;

public class HUD extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Popups popups;

	private static int Mood = 100;
	private int greenValue = 255;
	int txty = 90;
	int boxwidth = 200;
	int boxheight = 50;
	int boxy = 120;
	int multipos = 550;
	int canteenpos = multipos+200;
	int librarypos = multipos+400;
	int parkingpos = multipos+600;

	public boolean mPop = false;
	public boolean mPopClose = false;

	public HUD(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();

		//Multisalen Button
		if(mouseOver(mx, my, multipos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.Multisalen;
		}

		//Library Button
		if(mouseOver(mx, my, canteenpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			game.gameState = STATE.Canteen;
		}
		//Canteen Button  
		if(mouseOver(mx, my, librarypos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.Library;
		}

		//Parking lot Button
		if(mouseOver(mx, my, parkingpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.ParkingLot;
		}

		if(mouseOver(mx,my, 1865, 0, 55, 55)) {
			game.gameState = STATE.Office;
			//mPop = true;
			//game.gameState = STATE.MultisalenPOP;

		}

		if(game.gameState == STATE.Multisalen) {
			if(mouseOver(mx,my, (game.WIDTH/2)+210, (game.HEIGHT/2)-250, 40, 40)){
				mPop = false;
				mPopClose = true;
				//handler.removeObject(MP);
				//game.gameState = STATE.Multisalen;
			}
		}



	}

	public void mouseReleased(MouseEvent e) {

	}

	public void tick() {
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



	public void render(Graphics g) throws IOException {

		//(game.HEIGHT/2)-img2.getHeight()/2

		if(game.gameState == STATE.Office) {
			//BufferedImage officeimg = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background0.jpg"));
			g.drawImage(ImageLoader.getImg(5), (game.WIDTH/2)-ImageLoader.getImg(5).getWidth()/2, 55, null);

		}



		if(game.gameState == STATE.Multisalen) {
			//Font fnt3 = new Font("Verdana",1,100);
			//g.setFont(fnt3);
			//g.drawString("Welcome to Multisalen!", 400, Game.HEIGHT/2);
			//BufferedImage img2 = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background1.jpg"));

			//BufferedImage img2 = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background1.jpg"));
			g.drawImage(ImageLoader.getImg(1), (game.WIDTH/2)-ImageLoader.getImg(1).getWidth()/2, 55, null);
			//if(img2 != null)
			//g.drawImage(img2, (game.WIDTH/2)-img2.getWidth()/2, 55, null);

			//BufferedImage officeBtn = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\desk.png"));


			if(mPop == true) {
				mPopClose = false;
				g.setColor(Color.blue);
				g.fillRect((game.WIDTH/2)-250, (game.HEIGHT/2)-250, 500, 500);
				g.setColor(Color.red);
				g.drawRect((game.WIDTH/2)+210, (game.HEIGHT/2)-250, 40, 40);
				g.setColor(Color.yellow);


				BufferedImage img = null;
				img = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\btn.png"));
				g.drawImage(img, (game.WIDTH/2)-230, (game.HEIGHT/2)+150, null);

			}
		}



		if(game.gameState == STATE.Canteen) {
			//Font fnt3 = new Font("Verdana",1,100);
			//g.setFont(fnt3);
			//g.drawString("Welcome to the Canteen!", 400, Game.HEIGHT/2);
			//BufferedImage img = null;
			//img = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background2.jpg"));
			g.drawImage(ImageLoader.getImg(2), (game.WIDTH/2)-ImageLoader.getImg(2).getWidth()/2, 55, null);


			/*	if(canteen pop up == true) {
				draw canteen popup


			}

			 */

		}
		if(game.gameState == STATE.Library) {
			//Font fnt3 = new Font("Verdana",1,100);
			//g.setFont(fnt3);
			//g.drawString("Welcome to the Library!", 400, Game.HEIGHT/2);
			//BufferedImage img = null;
			//img = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background3.jpg"));
			g.drawImage(ImageLoader.getImg(3), (game.WIDTH/2)-ImageLoader.getImg(3).getWidth()/2, 55, null);
		}
		if(game.gameState == STATE.ParkingLot) {
//			Font fnt3 = new Font("Verdana",1,100);
//			g.setFont(fnt3);
//			g.drawString("Welcome to the Parking lot!", 400, Game.HEIGHT/2);
//			BufferedImage img = null;
//			img = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\background4.jpg"));
			g.drawImage(ImageLoader.getImg(4), (game.WIDTH/2)-ImageLoader.getImg(4).getWidth()/2, 55, null);
		}

		//popups.render(g);


//		BufferedImage grayField = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\grayField2.jpg"));
		g.drawImage(ImageLoader.getImg(6), 0, 950, null);
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(15, 15, Mood*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);

		Font fnt = new Font("Courier",1,20);
		g.setFont(fnt);
		g.setColor(Color.black);
		//Multisalen
		g.drawRect(multipos, Game.HEIGHT-boxy, boxwidth, boxheight);
		g.drawString("MULTISALEN", 590, Game.HEIGHT-txty);

		//LÃ¤nken
		g.drawRect(canteenpos, Game.HEIGHT-boxy, boxwidth, boxheight);
		g.drawString("CANTEEN", 810, Game.HEIGHT-txty);

		//Biblan
		g.drawRect(librarypos, Game.HEIGHT-boxy, boxwidth, boxheight);
		g.drawString("LIBRARY", 1010, Game.HEIGHT-txty);

		//Parkering
		g.drawRect(parkingpos, Game.HEIGHT-boxy, boxwidth, boxheight);
		g.drawString("PARKING LOT", 1180, Game.HEIGHT-txty);


	}




}