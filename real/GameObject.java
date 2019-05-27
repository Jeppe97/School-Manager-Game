package real;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public abstract class GameObject {
	// money, mood and students etc are all GameObjects which extends this abstract class.
	// This means that they all can use these variables that we create here and they also have to use the methods tick and render.
	// Since we can create the variables here instead of in the money class for example it makes the code a lot less cluttered.
	// And gives our game a nice structure since all the GameObjects classes are very similar, it's easy to navigate and also makes it very modular.

	protected int x;
	protected int y;
	protected ID id;
	protected int velX, velY;
	protected static int money;
	protected String moneyString;
	protected static int student;
	protected String studentString;
	protected static int mood;
	protected int greenValue;
	protected static int tables;
	protected static String tableString;
	protected static int parkingLots;
	protected static String parkingLotsString;
	protected static int groupRooms;
	protected static String groupRoomString;

	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick();
	public abstract void render(Graphics g) throws IOException;
	public abstract Rectangle getBounds();
	public abstract void destroy();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	
}
