package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Money extends GameObject{
	
	
	long startTime = System.currentTimeMillis();
	
	public Money(int x, int y, ID id) {
		super(x, y, id);
		
		money= 20000;
	}
	public void tick() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		if((elapsedTime/1000)>=10) {
			money+=(student/0.25);
			startTime = System.currentTimeMillis();
		}
		moneyString = Integer.toString(money);
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Money : "+moneyString, 250, 35);
	}
	public String buy(int price) {
		String message="You dont have enough money";
		if(price<=money) {
			money-=price;
		}
		return message;
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
