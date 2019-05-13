package real;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	
	public static BufferedImage multisalen;
	public static BufferedImage canteen;
	public static BufferedImage library;
	public static BufferedImage parkinglot;
	public static BufferedImage office;
	public static BufferedImage toprow;
	public static BufferedImage bottomrow;
	public static BufferedImage row;
	public static BufferedImage button;
	public static BufferedImage desk;
	public static BufferedImage imgplaceholder;
	
	
	public static void load() {
		
		try {
			multisalen = ImageIO.read(new File("res/multisalen.jpg"));
			canteen = ImageIO.read(new File("res/canteen.jpg"));
			library = ImageIO.read(new File("res/library.jpg"));
			parkinglot = ImageIO.read(new File("res/parkinglot.jpg"));
			office = ImageIO.read(new File("res/office.jpg"));
			row = ImageIO.read(new File("res/grayfield2.jpg"));
			desk = ImageIO.read(new File("res/desk.png"));
			//canteen = ImageIO.read(new File("res/canteen.jpg"));
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static BufferedImage getImg(int num) {
	
		if(num == 1)
			return multisalen;
		else if(num == 2)
			return canteen;
		else if(num == 3)
			return library;
		else if(num == 4)
			return parkinglot;
		else if(num == 5)
			return office;
		else if(num == 6)
			return row;
		else if (num == 7)
			return desk;
		else
			return null;	
	}
	
	
	
}
