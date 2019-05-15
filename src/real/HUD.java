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
	private Tables table;


	int txty = 90;
	int boxwidth = 200;
	int boxheight = 50;
	int boxy = 120;
	int multipos = 550;
	int canteenpos = multipos+200;
	int librarypos = multipos+400;
	int parkingpos = multipos+600;
	boolean tableObjectAdded = false;

	private boolean mPop = false;
	private boolean cPop = false;
	private boolean broke = false;

	public HUD(Game game, Handler handler) {
		table = new Tables(200,200,ID.TABLES);
		this.game = game;
		this.handler = handler;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();
		//Multisalen Button
		if(mouseOver(mx, my, multipos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.MULTISALEN;
		}

		//Library Button
		if(mouseOver(mx, my, canteenpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			game.gameState = STATE.CANTEEN;
		}
		//Canteen Button  
		if(mouseOver(mx, my, librarypos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.LIBRARY;
		}

		//Parking lot Button
		if(mouseOver(mx, my, parkingpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {

			game.gameState = STATE.PARKINGLOT;
		}
		if(mouseOver(mx,my, 1865, 0, 55, 55)&&game.gameState == STATE.CANTEEN) {
			
			cPop = true;
			//game.gameState = STATE.Office;
			//mPop = true;
			//game.gameState = STATE.MultisalenPOP;

		}
		if(mouseOver(mx, my, (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, 75, 100) && cPop) {
			if(!tableObjectAdded) {
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
			if(game.gameState == STATE.CANTEEN && mouseOver(mx,my, (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40)){
				mPop = false;
				if(tableObjectAdded) {
				handler.removeObject(table);
				tableObjectAdded = false;
				}
				cPop = false;
				
			}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// Do nothing because we don't have any mouseReleased events.
	}

	public void tick() {
		//Is empty because we don't have anything that needs to tick in this class.
	}	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {

		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}



	public void render(Graphics g){


		if(game.gameState == STATE.OFFICE) {
			cPop=false;
			g.drawImage(ImageLoader.getImg(5), (Game.WIDTH/2)-ImageLoader.getImg(5).getWidth()/2, 55, null);

		}



		if(game.gameState == STATE.MULTISALEN) {
			cPop=false;
			g.drawImage(ImageLoader.getImg(1), (Game.WIDTH/2)-ImageLoader.getImg(1).getWidth()/2, 55, null);

			if(mPop) {
				g.setColor(Color.blue);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.setColor(Color.red);
				g.drawRect((Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40);
				g.setColor(Color.yellow);


				g.drawImage(ImageLoader.getImg(8), (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, null);

			}
		}



		if(game.gameState == STATE.CANTEEN) {
			g.drawImage(ImageLoader.getImg(2), (Game.WIDTH/2)-ImageLoader.getImg(2).getWidth()/2, 55, null);

			if(cPop) {
				g.setColor(Color.blue);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.setColor(Color.red);
				g.drawRect((Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40);
				g.setColor(Color.yellow);
				
				if(broke) {
					g.setColor(Color.red);
					g.fillRect(Game.WIDTH/2-100, Game.HEIGHT/2-100, 200, 200);
					g.setColor(Color.black);
					g.drawString("You can't afford n/ another table", Game.WIDTH/2, Game.HEIGHT/2);
				}


				g.drawImage(ImageLoader.getImg(8), (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, null);
				
			}
			/*Soon to be implemented if(canteen pop up == true) {
				Soon to be implemented draw canteen popup
				Soon }
			 */

		}
		if(game.gameState == STATE.LIBRARY) {
			cPop=false;

			g.drawImage(ImageLoader.getImg(3), (Game.WIDTH/2)-ImageLoader.getImg(3).getWidth()/2, 55, null);
		}
		if(game.gameState == STATE.PARKINGLOT) {

			g.drawImage(ImageLoader.getImg(4), (Game.WIDTH/2)-ImageLoader.getImg(4).getWidth()/2, 55, null);
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