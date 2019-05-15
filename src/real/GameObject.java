package real;

import java.awt.Graphics;
import java.io.IOException;

public abstract class GameObject {
	
	protected int x,y;
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
	
	public String getStudentString() {
		return studentString;
	}
	public void setStudentString(String studentString) {
		this.studentString = studentString;
	}
	public int getMood() {
		return GameObject.mood;
	}
	public void setMood(int mood) {
		GameObject.mood += mood;
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
		GameObject.money += money;
	}
	public int getMoney() {
		return GameObject.money;
	}
	public int getStudent() {
		return GameObject.student;
	}
	public void setStudent(int student) {
		GameObject.student += student;
	}
	

}
