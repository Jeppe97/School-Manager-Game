package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Money extends GameObject{
	
	
	private int counter=0;
	public Money(int x, int y, ID id) {
		super(x, y, id);
		
		moneyTest = 10;
	}

	
	public void tick() {
		if(counter>=1000)
			counter=0;
		
		counter++;
		
		if(counter%2==0)
		moneyTest++;
		
		moneyTest2 = Integer.toString(moneyTest);
	}

	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Money : "+moneyTest2, 20, 20);
		
		
	}

}
