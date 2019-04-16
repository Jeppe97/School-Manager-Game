package real;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Money extends GameObject{

	long startTime = System.currentTimeMillis();
	long startTime2 = System.currentTimeMillis();
	
	public Money(int x, int y, ID id) {
		super(x, y, id);
		money = 10;
	}
	public void tick() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		long elapsedTime2 = System.currentTimeMillis() - startTime2;
		if((elapsedTime/1000)>=2) {
			money+=(money+student);
			startTime = System.currentTimeMillis();
		}
		if(elapsedTime2/1000>=2.3) {
			buy(100);
			startTime2 = System.currentTimeMillis();
		}
		moneyString = Integer.toString(money);
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("$ : "+moneyString, 15, 70);
	}
	public String buy(int price) {
		String message="You dont have enough money";
		if(price<=money) {
			money-=price;
		}
		return message;
	}
}

