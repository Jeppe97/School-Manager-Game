package real;
import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x,y;
	protected ID id;
	protected int money;
	protected String moneyString;
	protected int student;
	protected String studentString;


public GameObject(int x, int y,ID id) {
	this.x = x;
	this.y = y;
	this.id = id;
}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
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
	public void setMoneyTest(int money) {
		this.money = money;
	}
	public int getMoneyTest() {
		return money;
	}
	

}