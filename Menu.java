package real;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Menu", 240, 70);
		
		g.setFont(fnt2);
		g.drawRect(200, 100, 200, 64);
		g.drawString("Play", 270, 140);
		
		g.drawRect(200, 200, 200, 64);
		g.drawString("Help", 270, 240);
		
		g.drawRect(200, 300, 200, 64);
		g.drawString("Quit", 270, 340);
	}

}
