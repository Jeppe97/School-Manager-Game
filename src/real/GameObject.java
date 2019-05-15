package real;

import java.awt.Graphics;
import java.io.IOException;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected ID id;
	protected static int money;
	protected String moneyString;
	protected static int student;
	protected String studentString;
	protected static int mood;
	protected int greenValue;
	protected static int tables;


public GameObject(int x, int y,ID id) {
	this.x = x;
	this.y = y;
	this.id = id;
}
	public abstract void tick();
	public abstract void render(Graphics g) throws IOException;
}
