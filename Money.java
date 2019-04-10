package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Money extends GameObject{
	
	
	private int counter=0;
	private int nrStudents=10;
	private int amountPerStudentDay=1000;
	
	public Money(int x, int y, ID id) {
		super(x, y, id);
		
		moneyTest = 1000;
	}
	public void tick() {
		if(counter>=1000)
			counter=0;
		
		counter++;
		
		if(counter%100==0) {
		moneyTest=moneyTest+(amountPerStudentDay*nrStudents); //Ökar amount of money varje dag och är beroende av hur många studneter
		moneyTest2 = Integer.toString(moneyTest);
		}
		if(counter%2==0)
		{
			amountDecreaseBuy(100);
			moneyTest2 = Integer.toString(moneyTest);
		}
	}

	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Money : "+moneyTest2, 20, 20);
		
		
	}
	public String amountDecreaseBuy(int price)
	{
		
		String message="You don't have enough of money";
		if(price <= moneyTest)
		{
			moneyTest= moneyTest-price;
			
		}
		return message;
	}

}
