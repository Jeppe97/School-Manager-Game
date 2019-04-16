package real;
import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x,y;
	protected ID id;
	protected int money;
	protected String moneyString;
	protected int student;
	protected String studentString;
	protected int mood;
	protected int greenValue;


public GameObject(int x, int y,ID id) {
	this.x = x;
	this.y = y;
	this.id = id;
}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public String getStudentString() {
		return studentString;
	}
	public void setStudentString(String studentString) {
		this.studentString = studentString;
	}
	public int getMood() {
		return mood;
	}
	public void setMood(int mood) {
		this.mood += mood;
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
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setMoney(int money) {
		this.money += money;
	}
	public int getMoney() {
		return money;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student += student;
	}
	

}