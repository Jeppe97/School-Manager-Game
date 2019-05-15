package real;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 7249936825495199895L;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int WIDTH = (int) screenSize.getWidth(); //Gets the Width and Height of your monitor.
	public static final int HEIGHT = (int) screenSize.getHeight();
	
	private Thread thread;
	private boolean running = false; 
	
	private Handler handler;
	private Menu menu;
	private HUD hud;
	
	private Graphics g;
	
	public enum STATE { //Here we keep all the different states that we use in our game, for example the menu state at the start of the game, the office state for when you're in your office etc.
		MENU,
		GAME,
		HELP,
		MULTISALEN,
		OFFICE,
		MULTISALENPOP,
		CANTEEN,
		LIBRARY,
		PARKINGLOT
	}
	
	protected STATE gameState = STATE.MENU; //Start the game at the menu state. 
	
	int standardWidth = 800;
	int standardHeight = 600;
	int screenWidth;
	int screenHeight; 

	public Game(){
		handler = new Handler(); //Initializes the handler which keeps all the GameObjects in a list.
		menu = new Menu(this, handler); //Initializes the menu class where we then render the graphic for the menu.
		this.addMouseListener(menu); //Adds the possibility to listen to mouse clicks in the menu.
		hud = new HUD(this,handler); //Initializes the HUD class, where we keep most of the information that is always visible.
		this.addMouseListener(hud);//Adds the possibility to listen to mouse clicks in the HUD (Head-up-display).
		
		ImageLoader.load();
		
		
		new Window(WIDTH, HEIGHT, "School Manager Game", this); //Creates the game window which is the foundation of our game. The base window so to speak.
	}
	public synchronized void start() { //Quite self-explanatory, sets running = true which means the game is running, and also starts the thread which the game runs in/upon.
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() { //If we were to stop the game, this method would do that for us by setting running = false.
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() { 
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				try {
					render();
				} catch (IOException e) {
					e.printStackTrace();
				}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick() { 
		//Tick is a method which we use throughout the entirety of our game and it's basically an update method, so if we want a variable to be updated according to a specific condition
		//we can use this method for that.
		
			handler.tick(); //Updates the handler, which will loop through all the GameObjects and update them.
			if(gameState == STATE.GAME || gameState == STATE.CANTEEN || gameState == STATE.LIBRARY || gameState == STATE.PARKINGLOT || gameState == STATE.MULTISALEN || gameState == STATE.MULTISALENPOP){
				hud.tick(); //Updates the HUD if we're in any of our different rooms where the HUD is visible.
				
			}else if(gameState == STATE.MENU) {
				menu.tick(); //Updates the HUD if we're in the menu state.
			}	
	}
	private void render() throws IOException { 
		//This is our render method which, like tick, we use through the entirety of our game. It renders everything that you can see on the screen.
		//Every GameObject class and most of the other classes have individual render methods to render their graphical components, but they all work the same way.
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.GAME || gameState == STATE.CANTEEN || gameState == STATE.LIBRARY || gameState == STATE.PARKINGLOT || gameState == STATE.MULTISALEN || gameState == STATE.MULTISALENPOP || gameState == STATE.OFFICE){
			hud.render(g); //If we're in any on our room states then we render the HUD.
		
			
		}else if(gameState == STATE.MENU || gameState == STATE.HELP) {
			menu.render(g); //If we're in the menu state, we render the menu.
		}
		
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var, int min, int max) {
		if(var>=max) {
			var = max;
			return var;
		}
		else if (var<=min) {
			var = min;
			return var;
		}
		else
			return var;
	}
	public static void main(String[] args) {
		new Game();
	}
}
