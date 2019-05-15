package real;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TopRow extends GameObject {

	protected int x,y;
	protected ID id;
	
	public TopRow(int x, int y,ID id){
		super(x, y, id);
		this.id = id;
		this.x = x;
		this.y = y;
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) throws IOException {

		//BufferedImage grayField2 = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\grayField2.jpg"));
		g.drawImage(ImageLoader.getImg(6), 0, -20, null);
		
		//BufferedImage officeBtn = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\desk.png"));
		g.drawImage(ImageLoader.getImg(7), 1865, 0, null);
		g.drawRect(1865, 0, 55, 55);
		
		
		
		
	}
	
	
}
