package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HUD extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Tables table;
	private ParkingLots parkinglot;
	private GroupRooms groupRoom;
	private Minigame minigame;

	int txty = 90;
	int boxwidth = 200;
	int boxheight = 50;
	int boxy = 120;
	int multipos = 550;
	int canteenpos = multipos+200;
	int librarypos = multipos+400;
	int parkingpos = multipos+600;
	int brokeCounter = 0;
	int cooldown = 0;
	boolean tableObjectAdded = false;
	boolean parkingObjectAdded = false;
	boolean groupRoomObjectAdded = false;
	boolean playeradded = false;
	boolean stillOnCoolDown = false;

	private boolean mPop = false;	//Multisalen popup
	private boolean cPop = false;	//Canteen popup
	private boolean oPop = false;	//Office popup
	private boolean lPop = false;	//Library popup
	private boolean plPop = false;	//ParkingLot popup

	private boolean broke = false;	//indicator if you are, in fact, broke

	public HUD(Game game, Handler handler) {
		table = new Tables(200,200,ID.TABLES);
		parkinglot = new ParkingLots(200,200,ID.PARKINGS);
		groupRoom = new GroupRooms(200,200,ID.GROUPROOM);
		minigame = new Minigame(handler);
		this.game = game;
		this.handler = handler;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();

		//Multisalen Button
		if(mouseOver(mx, my, multipos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			Game.gameState = real.Game.STATE.MULTISALEN;
		}
		//Library Button
		if(mouseOver(mx, my, canteenpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			Game.gameState = real.Game.STATE.CANTEEN;
		}
		//Canteen Button  
		if(mouseOver(mx, my, librarypos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			Game.gameState = real.Game.STATE.LIBRARY;
		}
		//Parking lot Button
		if(mouseOver(mx, my, parkingpos, Game.HEIGHT-boxy, boxwidth, boxheight)) {
			Game.gameState = real.Game.STATE.PARKINGLOT;
		}
		if(mouseOver(mx,my, 1865, 0, 55, 55)) {
			Game.gameState = real.Game.STATE.OFFICE;
		}

		//All Room buttons
		if(mouseOver(mx,my, 900, 500, 200, 150)) {
			if(Game.gameState == real.Game.STATE.CANTEEN)
				cPop = true;
			else if(Game.gameState == real.Game.STATE.LIBRARY)
				lPop = true;
			else if(Game.gameState == real.Game.STATE.MULTISALEN)
				mPop = true;
			else if(Game.gameState == real.Game.STATE.OFFICE)
				oPop = true;
			else if(Game.gameState == real.Game.STATE.PARKINGLOT)
				plPop = true;
		}

		//exam button
		if(mouseOver(mx, my, (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, 142, 64) && Game.gameState == real.Game.STATE.MULTISALEN) {
			
			if(minigame.getCooldown() == 0) {
				AudioPlayer.getSound("exam_sound").play();
				Game.gameState = Game.STATE.MINIGAME;
			}
			if(minigame.getCooldown() > 0) {
				stillOnCoolDown = true;
			}
		}
		
		
		//Buy one artifact button
		if(mouseOver(mx, my, (Game.WIDTH/2)-220, (Game.HEIGHT/2)+75, 200, 150)) {
			if(cPop || lPop || plPop) {
				if(GameObject.money<=1000) {
					broke = true;
					AudioPlayer.getSound("buy_denied").play();
				}
				else {
					AudioPlayer.getSound("buy_sound").play();;
					if(cPop) {
						broke = false;
						GameObject.tables++;
						GameObject.money-=1000;
					}
					else if(lPop) {
						broke = false;
						GameObject.groupRooms++;
						GameObject.money-=1000;
					}
					else if(plPop) {
						broke = false;
						GameObject.parkingLots++;
						GameObject.money-=1000;
					}
				}		
			}		
		}

		//Buy 10 artifacts button
		if(mouseOver(mx, my, (Game.WIDTH/2)+20, (Game.HEIGHT/2)+75, 200, 150)){
			if(cPop || lPop || plPop) {
				if(GameObject.money<=(1000*10)) {
					broke = true;
					AudioPlayer.getSound("buy_denied").play();
				}
				else {
					AudioPlayer.getSound("buy_sound").play();
					if(cPop) {
						broke = false;
						GameObject.tables+=10;
						GameObject.money-=(1000*10);
					}
					else if(lPop) {
						broke = false;
						GameObject.groupRooms+=10;
						GameObject.money-=(1000*10);
					}
					else if(plPop) {
						broke = false;
						GameObject.parkingLots+=10;
						GameObject.money-=(1000*10);
					}	
				}	
			}
		}

		//close popup
		if(mouseOver(mx,my, (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40)){

			if(Game.gameState == real.Game.STATE.CANTEEN && cPop) {
				cPop = false;
				if(tableObjectAdded) {
					handler.removeObject(table);
					tableObjectAdded = false;
				}
			}
			else if(Game.gameState == real.Game.STATE.LIBRARY && lPop) {
				lPop = false;
				if(groupRoomObjectAdded) {
					handler.removeObject(groupRoom);
					groupRoomObjectAdded = false;
				}
			}
			else if(Game.gameState == real.Game.STATE.PARKINGLOT && plPop) {
				plPop = false;
				if(parkingObjectAdded) {
					handler.removeObject(parkinglot);
					parkingObjectAdded = false;
				}
			}
			else if(Game.gameState == real.Game.STATE.MULTISALEN && mPop) {
				mPop = false;
				stillOnCoolDown = false;
			}
			else if(Game.gameState == real.Game.STATE.OFFICE && oPop) {
				oPop = false;
			}

			broke = false;
		}
	}

	public void mouseReleased(MouseEvent e) {
		// Do nothing because we don't have any mouseReleased events.
	}

	public void tick() {
		
		if(Game.gameState == Game.STATE.MINIGAME) {
			minigame.tick();
		}
		if(minigame.getCooldown() > 0) {
			minigame.setCooldown(1);
		}
		if(minigame.getCooldown() == 0) {
			stillOnCoolDown = false;
		}
		
		//Is mostly empty because we don't have anything that needs to tick in this class.
	}	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {

		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}

	public void render(Graphics g){
		//Everything everything office ====================================================================================================================================
		if(Game.gameState == real.Game.STATE.OFFICE) {
			cPop=false;
			mPop=false;
			plPop=false;
			lPop = false;
			g.drawImage(ImageLoader.getImg("office"), (Game.WIDTH/2)-ImageLoader.getImg("office").getWidth()/2, 55, null);
			g.drawImage(ImageLoader.getImg("officebutton1"), 900, 500, null);
			
			if(oPop) {
				g.setColor(Color.blue);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.drawImage(ImageLoader.getImg("closeBtn"), (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("You now have: "+GameObject.tableString+ " tables", 720,350);
				g.drawString("You now have: " + GameObject.groupRoomString + " group rooms", 720,380);
				g.drawString("You now have: " + GameObject.parkingLotsString + " parking lots", 720,410);
			}
		}

		//Everything everything multisalen ====================================================================================================================================
		if(Game.gameState == real.Game.STATE.MULTISALEN) {
			cPop=false;
			oPop=false;
			plPop=false;
			lPop = false;

			g.drawImage(ImageLoader.getImg("multisalen"), (Game.WIDTH/2)-ImageLoader.getImg("multisalen").getWidth()/2, 55, null);
			g.drawImage(ImageLoader.getImg("multisalenbutton1"), 900, 500, null);
			
			if(mPop) {
				g.setColor(Color.blue);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.drawImage(ImageLoader.getImg("closeBtn"), (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("Cooldown on minigame: "+ minigame.getCooldown(), 720,350);
				g.setColor(Color.yellow);
				g.drawImage(ImageLoader.getImg("button"), (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, null);
				
				if(stillOnCoolDown) {
					if(brokeCounter != 500) {
						g.setColor(Color.red);
						g.fillRect(Game.WIDTH/2-300, Game.HEIGHT/2-75, 600, 150);
						g.setColor(Color.black);
						g.drawString("You can't play yet! Still on cooldown.", Game.WIDTH/2-180, Game.HEIGHT/2+5);
						brokeCounter++;
					}
					if(brokeCounter == 500) {
						brokeCounter = 0;
						stillOnCoolDown = false;
					}
	
				}
				
			}
		}

		//Everything everything canteen ====================================================================================================================================
		if(Game.gameState == real.Game.STATE.CANTEEN) {
			mPop=false;
			oPop=false;
			plPop=false;
			lPop = false;

			g.drawImage(ImageLoader.getImg("canteen"), (Game.WIDTH/2)-ImageLoader.getImg("canteen").getWidth()/2, 55, null);
			g.drawImage(ImageLoader.getImg("canteenbutton1"), 900, 500, null);

			if(cPop) {
				g.setColor(Color.gray);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.drawImage(ImageLoader.getImg("closeBtn"), (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, null);
				g.setColor(Color.yellow);

				if(broke) {
					if(brokeCounter != 500) {
						g.setColor(Color.red);
						g.fillRect(Game.WIDTH/2-200, Game.HEIGHT/2-75, 400, 150);
						g.setColor(Color.black);
						g.drawString("You can't afford another table!", Game.WIDTH/2-180, Game.HEIGHT/2+5);
						brokeCounter++;
					}
					if(brokeCounter == 500) {
						brokeCounter = 0;
						broke = false;
					}
					if(GameObject.money > 1000)
						broke = false;
				}
				if(!tableObjectAdded) {
					handler.addObject(table);
					tableObjectAdded = true;
				}
				g.drawImage(ImageLoader.getImg("canteenbutton2"), (Game.WIDTH/2)-220, (Game.HEIGHT/2)+75, null);
				g.drawImage(ImageLoader.getImg("canteenbutton3"),  (Game.WIDTH/2)+20, (Game.HEIGHT/2)+75, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("You now have: "+GameObject.tableString+ " tables", 720,350);
				g.drawString("Price of a table is: 1000", 720, 320);
			}
		}
		//Everything everything library ====================================================================================================================================
		if(Game.gameState == real.Game.STATE.LIBRARY) {
			cPop=false;
			oPop=false;
			plPop=false;
			mPop = false;

			g.drawImage(ImageLoader.getImg("library"), (Game.WIDTH/2)-ImageLoader.getImg("library").getWidth()/2, 55, null);
			g.drawImage(ImageLoader.getImg("librarybutton1"), 900, 500, null);

			if(lPop) {
				g.setColor(Color.gray);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.drawImage(ImageLoader.getImg("closeBtn"), (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, null);

				if(broke) {
					if(brokeCounter != 500) {
						g.setColor(Color.red);
						g.fillRect(Game.WIDTH/2-300, Game.HEIGHT/2-75, 600, 150);
						g.setColor(Color.black);
						g.drawString("You can't afford another group room!", Game.WIDTH/2-200, Game.HEIGHT/2+5);
						brokeCounter++;
					}
					if(brokeCounter == 500) {
						brokeCounter = 0;
						broke = false;
					}
					if(GameObject.money > 1000)
						broke = false;
				}
				if(!groupRoomObjectAdded) {
					handler.addObject(groupRoom);
					groupRoomObjectAdded = true;
				}
				g.drawImage(ImageLoader.getImg("librarybutton2"), (Game.WIDTH/2)-220, (Game.HEIGHT/2)+75, null);
				g.drawImage(ImageLoader.getImg("librarybutton3"),  (Game.WIDTH/2)+20, (Game.HEIGHT/2)+75, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("You now have: " + GameObject.groupRoomString + " group rooms", 720,350);
				g.drawString("Price of a group room is: 1000", 720, 320);
			}

		}
		//Everything everything parking lots ====================================================================================================================================
		if(Game.gameState == real.Game.STATE.PARKINGLOT) {
			cPop=false;
			oPop=false;
			mPop=false;
			lPop = false;
			
			g.drawImage(ImageLoader.getImg("parkinglot"), (Game.WIDTH/2)-ImageLoader.getImg("parkinglot").getWidth()/2, 55, null);
			g.drawImage(ImageLoader.getImg("parkingbutton1"), 900, 500, null);

			if(plPop) {
				g.setColor(Color.gray);
				g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
				g.drawImage(ImageLoader.getImg("closeBtn"), (Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, null);
				if(broke) {
					if(brokeCounter != 500) {
						g.setColor(Color.red);
						g.fillRect(Game.WIDTH/2-300, Game.HEIGHT/2-75, 600, 150);
						g.setColor(Color.black);
						g.drawString("You can't afford another parking lot!", Game.WIDTH/2-200, Game.HEIGHT/2+5);
						brokeCounter++;
					}
					if(brokeCounter == 500) {
						brokeCounter = 0;
						broke = false;
					}
					if(GameObject.money > 1000)
						broke = false;
				}
				if(!parkingObjectAdded) {
					handler.addObject(parkinglot);
					parkingObjectAdded = true;
				}
				g.drawImage(ImageLoader.getImg("parkingbutton2"), (Game.WIDTH/2)-220, (Game.HEIGHT/2)+75, null);
				g.drawImage(ImageLoader.getImg("parkingbutton3"),  (Game.WIDTH/2)+20, (Game.HEIGHT/2)+75, null);
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("You now have: " + GameObject.parkingLotsString + " parking lots", 720,350);
				g.drawString("Price of a parking lot is: 1000", 720, 320);
			}		
		}
		//Everything not specific rooms ============================================================================================================================================

		if(Game.gameState == Game.STATE.MINIGAME) {
			
			minigame.render(g);
			
		}
		
		if(Game.gameState != Game.STATE.MINIGAME) {
		g.drawImage(ImageLoader.getImg("row"), 0, 950, null);

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
}