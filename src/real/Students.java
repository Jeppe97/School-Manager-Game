package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Students extends GameObject{

	private int posy = 35;
	private int posx = 400;
	long startTime = System.currentTimeMillis();
	public Students(int x, int y, ID id) {
		super(x, y, id);
		
		student = 1000;
	}
	public void studentsDropOut()
	{
		
	}
	
	public void tick() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		if((elapsedTime/1000)>=2) {

			if(GameObject.mood>=75) {
				student+=1000;
			}
			else if(GameObject.mood<75 && mood>=50) {
				student+=500;
			}
			else if(GameObject.mood<50 && GameObject.mood>10) {
				student-=50;
			}
			
			startTime = System.currentTimeMillis();
		}
		else if(GameObject.mood<=1) {
			//System.exit(0);
			mood = 100;
		}
		studentString = Integer.toString(student);
	}
	public void render(Graphics g) {
		if (student<100) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + student, posx, posy);
		}
		if (student<500 && student>=100)
		{
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + student, posx, posy);	
		}
		if (student>=500)
		{
		g.setColor(Color.green);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + student, posx, posy);	
		}
		
		
	}

}