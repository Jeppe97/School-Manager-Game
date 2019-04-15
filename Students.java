package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Students extends GameObject{

	private int studentTest;
	private String studentTest2;
	private int counter = 0;
	private int mood = 10;
	public Students(int x, int y, ID id) {
		super(x, y, id);
		
		studentTest = 100;
	}
	public void studentsDropOut()
	{
		
	}
	
	public void tick() {
		if (counter>=1000)
		{
			
			counter =0;
		}
		counter ++;	
		
		if(counter%1==0)
		{
			studentTest++;
			
			studentTest2 = Integer.toString(studentTest);
		}
		
		if(counter%10==0)
		{
			if(mood<70)
			{
				studentTest = studentTest -10;
			}
		}
		
		
	}

	
	
	
	public void render(Graphics g) {
		if (studentTest<100) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + studentTest2, 15, 100);
		}
		if (studentTest<500 && studentTest>=100)
		{
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + studentTest2, 15, 100);	
		}
		if (studentTest>=500)
		{
		g.setColor(Color.green);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Students: " + studentTest2, 15, 100);	
		}
		
		
	}

}