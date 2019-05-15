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
	private Students g;
	private Tables table;

//	private static int Mood = 100;
	private int greenValue = 255;
	int txty = 90;
	int boxwidth = 200;
	int boxheight = 50;
	int boxy = 120;
	int multipos = 550;
	int canteenpos = multipos+200;
	int librarypos = multipos+400;
	int parkingpos = multipos+600;
	boolean tableObjectAdded = false;

	public boolean mPop = false;
	public boolean cPop = false;
	public boolean broke = false;

	public boolean mPopClose = false;

	public HUD(Game game, Handler handler) {
		table = new Tables(200,200,ID.Tables);
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
		if(mouseOver(mx,my, 1865, 0, 55, 55)&&game.gameState == STATE.Canteen) {
			
			cPop = true;
			//game.gameState = STATE.Office;
			//mPop = true;
			//game.gameState = STATE.MultisalenPOP;

		}
		if(mouseOver(mx, my, (game.WIDTH/2)-230, (game.HEIGHT/2)+150, 75, 100) && cPop == true) {
			if(tableObjectAdded == false) {
				handler.addObject(table);
				tableObjectAdded = true;
			}
			GameObject.tables++;
			if(GameObject.money<=1000) {
				broke = true;
			}
			else {
				broke = false;
				GameObject.money-=1000;

			}
		}

		if(game.gameState == STATE.Canteen) {
			if(mouseOver(mx,my, (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40)){
				mPop = false;
				if(tableObjectAdded) {
				handler.removeObject(table);
				tableObjectAdded = false;
				}
				cPop = false;
				mPopClose = true;
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


		if(game.gameState == STATE.Office) {
			cPop=false;
			g.drawImage(ImageLoader.getImg(5), (game.WIDTH/2)-ImageLoader.getImg(5).getWidth()/2, 55, null);

		}



		if(game.gameState == STATE.Multisalen) {
			cPop=false;
			g.drawImage(ImageLoader.getImg(1), (game.WIDTH/2)-ImageLoader.getImg(1).getWidth()/2, 55, null);

			if(mPop == true) {
				mPopClose = false;
				g.setColor(Color.blue);
				g.fillRect((game.WIDTH/2)-250, (game.HEIGHT/2)-250, 500, 500);
				g.setColor(Color.red);
				g.drawRect((game.WIDTH/2)+210, (game.HEIGHT/2)-250, 40, 40);
				g.setColor(Color.yellow);


				g.drawImage(ImageLoader.getImg(8), (game.WIDTH/2)-230, (game.HEIGHT/2)+150, null);

			}
		}



		if(game.gameState == STATE.Canteen) {
			g.drawImage(ImageLoader.getImg(2), (game.WIDTH/2)-ImageLoader.getImg(2).getWidth()/2, 55, null);

			if(cPop == true) {
				g.setColor(Color.blue);
				g.fillRect((game.WIDTH/2)-250, (game.HEIGHT/2)-250, 500, 500);
				g.setColor(Color.red);
				g.drawRect((game.WIDTH/2)+210, (game.HEIGHT/2)-250, 40, 40);
				g.setColor(Color.yellow);
				
				if(broke == true) {
					g.setColor(Color.red);
					g.fillRect(game.WIDTH/2-100, game.HEIGHT/2-100, 200, 200);
					g.setColor(Color.black);
					g.drawString("You can't afford n/ another table", game.WIDTH/2, game.HEIGHT/2);
				}


				g.drawImage(ImageLoader.getImg(8), (game.WIDTH/2)-230, (game.HEIGHT/2)+150, null);
				
			}
			/*	if(canteen pop up == true) {
				draw canteen popup


			}

			 */

		}
		if(game.gameState == STATE.Library) {
			cPop=false;

			g.drawImage(ImageLoader.getImg(3), (game.WIDTH/2)-ImageLoader.getImg(3).getWidth()/2, 55, null);
		}
		if(game.gameState == STATE.ParkingLot) {

			g.drawImage(ImageLoader.getImg(4), (game.WIDTH/2)-ImageLoader.getImg(4).getWidth()/2, 55, null);
		}



		g.drawImage(ImageLoader.getImg(6), 0, 950, null);

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