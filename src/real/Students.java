package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Students extends GameObject{

	private int posy = 35;
	private int posx = 450;
	long startTime = System.currentTimeMillis();
	public Students(int x, int y, ID id) {
		super(x, y, id);
		
		student = 100;
	}
	public void studentsDropOut()
	{
		//Is empty because it's in development
	}
	
	public void tick() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		if((elapsedTime/1000)>=10) {
			if(GameObject.mood>=50) {
				student+=(student/0.9)-student;
				startTime = System.currentTimeMillis();
			}
			else if(GameObject.mood<50 && GameObject.mood>5) {
				student-=10;
				startTime = System.currentTimeMillis();
			}
		}
		else if(GameObject.mood<=5) {
			System.exit(0);
		}
		studentString = Integer.toString(student);
	}
	public void render(Graphics g) {
		
		String students = "Students: ";
		String arial = "Arial";
		
		if (student<100) {
		g.setColor(Color.RED);
		g.setFont(new Font(arial,Font.BOLD,20));
		g.drawString(students + student, posx, posy);
		}
		if (student<500 && student>=100)
		{
		g.setColor(Color.YELLOW);
		g.setFont(new Font(arial,Font.BOLD,20));
		g.drawString(students + student, posx, posy);	
		}
		if (student>=500)
		{
		g.setColor(Color.green);
		g.setFont(new Font(arial,Font.BOLD,20));
		g.drawString(students + student, posx, posy);	
		}
		
		
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}