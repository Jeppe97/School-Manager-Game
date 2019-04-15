package real;
import java.awt.Graphics;

public abstract class GameObject {

	protected int x,y;
	protected ID id;
	protected int velX, velY;
	protected int moneyTest;
	protected String moneyTest2;
	protected int studentTest;
	protected String studentTest2;
	protected int Mood;


	public GameObject(int x, int y,ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);

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
	public void setMoneyTest(int moneyTest) {
		this.moneyTest = moneyTest;
	}
	public int getMoneyTest() {
		return moneyTest;
	}
	
	public int getMood(){
		return Mood;
	}
	
	public void setMood(int mood){
		this.Mood = mood;
	}


}