package real;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 7249936825495199895L;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int WIDTH = (int) screenSize.getWidth();
	public static final int HEIGHT = (int) screenSize.getHeight();
	
	private Thread thread;
	private boolean running = false; 
	
	private Handler handler;
	private Menu menu;
	private HUD hud;
	private MultiPOP pop1;
	public Window win;
	
	

	
	private Graphics g;
	
	public enum STATE {
		Menu,
		Game,
		Help,
		Multisalen,
		Office,
		MultisalenPOP,
		Canteen,
		Library,
		ParkingLot
	};
	
	public STATE gameState = STATE.Menu;
	
	int standardWidth = 800;
	int standardHeight = 600;
	int screenWidth, screenHeight; // Get these from your graphics device or the window you're drawing to.

	 // Draws a 100x100 rectangle in the bottom right corner.

	// Due to the scaling, if you are running on eg 1024x768, this becomes a 128x128 rectangle.

	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		hud = new HUD(this,handler);
		this.addMouseListener(hud);
		//hud.initImg();
		
		ImageLoader.load();
		
		
		win = new Window(WIDTH, HEIGHT, "School Manager Game", this);
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
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
					// TODO Auto-generated catch block
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
			handler.tick();
			if(gameState == STATE.Game || gameState == STATE.Canteen || gameState == STATE.Library || gameState == STATE.ParkingLot || gameState == STATE.Multisalen || gameState == STATE.MultisalenPOP){
				hud.tick();
				
			}else if(gameState == STATE.Menu) {
				menu.tick();
			}	
	}
	private void render() throws IOException {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.Game || gameState == STATE.Canteen || gameState == STATE.Library || gameState == STATE.ParkingLot || gameState == STATE.Multisalen || gameState == STATE.MultisalenPOP || gameState == STATE.Office){
			hud.render(g);
		
			
		}else if(gameState == STATE.Menu || gameState == STATE.Help) {
			menu.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var, int min, int max) {
		if(var>=max) {
			return var = max;
		}
		else if (var<=min) {
			return var = min;
		}
		else
			return var;
	}
	public static void main(String[] args) {
		new Game();
	}
}
