package real;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

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
	public Window win;
	
	private Graphics g;
	public enum STATE {
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
	
	public STATE gameState = STATE.MENU;
	
	int standardWidth = 800;
	int standardHeight = 600;
	int screenWidth;
	int screenHeight; 

	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		hud = new HUD(this,handler);
		this.addMouseListener(hud);
		
		ImageLoader.load();
		
		
		new Window(WIDTH, HEIGHT, "School Manager Game", this);
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
			if(gameState == STATE.GAME || gameState == STATE.CANTEEN || gameState == STATE.LIBRARY || gameState == STATE.PARKINGLOT || gameState == STATE.MULTISALEN || gameState == STATE.MULTISALENPOP){
				hud.tick();
				
			}else if(gameState == STATE.MENU) {
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
		
		if(gameState == STATE.GAME || gameState == STATE.CANTEEN || gameState == STATE.LIBRARY || gameState == STATE.PARKINGLOT || gameState == STATE.MULTISALEN || gameState == STATE.MULTISALENPOP || gameState == STATE.OFFICE){
			hud.render(g);
		
			
		}else if(gameState == STATE.MENU || gameState == STATE.HELP) {
			menu.render(g);
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
