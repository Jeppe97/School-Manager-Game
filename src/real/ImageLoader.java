package real;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	
	private static BufferedImage multisalen;
	private static BufferedImage canteen;
	private static BufferedImage library;
	private static BufferedImage parkinglot;
	private static BufferedImage office;
	//Not used yet private static BufferedImage toprow;
	//Not used yet private static BufferedImage bottomrow;
	private static BufferedImage row;
	private static BufferedImage button;
	private static BufferedImage desk;
	// Not used yet private static BufferedImage imgplaceholder;
	
	private ImageLoader(){
		throw new IllegalStateException("Utility Class");
	}
	
	public static void load() {
		
		try {
			multisalen = ImageIO.read(new File("res/multisalen.jpg"));
			canteen = ImageIO.read(new File("res/canteen.jpg"));
			library = ImageIO.read(new File("res/library.jpg"));
			parkinglot = ImageIO.read(new File("res/parkinglot.jpg"));
			office = ImageIO.read(new File("res/office.jpg"));
			row = ImageIO.read(new File("res/grayfield2.jpg"));
			desk = ImageIO.read(new File("res/desk.png"));
			button = ImageIO.read(new File("res/btn.png"));
		
		
		
		} catch (IOException e) {
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
		else if(num == 8)
			return button;
		else
			return null;	
	}
	
	
	
}
