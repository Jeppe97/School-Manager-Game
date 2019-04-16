package real;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Money extends GameObject{

	long startTime = System.currentTimeMillis();
	
	public Money(int x, int y, ID id) {
		super(x, y, id);
		
		money = 10;
	}
	public void tick() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		//int students = getStudent();
		if((elapsedTime/1000)>=2) {
			money+=1000;
			startTime = System.currentTimeMillis();
		}
		moneyString = Integer.toString(money);
	}

	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("$ : "+moneyString, 15, 70);
		
		
	}

}