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
	private static BufferedImage button1;
	private static BufferedImage desk;
	private static BufferedImage closeBtn;
	private static BufferedImage canteenBtn1;
	private static BufferedImage canteenBtn2;
	private static BufferedImage canteenBtn3;
	private static BufferedImage parkingBtn1;
	private static BufferedImage parkingBtn2;
	private static BufferedImage parkingBtn3;
	private static BufferedImage libraryBtn1;
	private static BufferedImage libraryBtn2;
	private static BufferedImage libraryBtn3;
	private static BufferedImage officeBtn1;
	private static BufferedImage multisalenBtn1;
	private static BufferedImage moodEnemy;
	private static BufferedImage moneyEnemy;

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
			row = ImageIO.read(new File("res/grayField2.png"));
			desk = ImageIO.read(new File("res/desk.png"));
			button1 = ImageIO.read(new File("res/btn.png"));
			closeBtn = ImageIO.read(new File("res/closeBtn.png"));
			canteenBtn1 = ImageIO.read(new File("res/canteenBtn1.png"));
			canteenBtn2 = ImageIO.read(new File("res/canteenBtn2.png"));
			canteenBtn3 = ImageIO.read(new File("res/canteenBtn3.png"));
			parkingBtn1 = ImageIO.read(new File("res/parkingBtn1.png"));
			parkingBtn2 = ImageIO.read(new File("res/parkingBtn2.png"));
			parkingBtn3 = ImageIO.read(new File("res/parkingBtn3.png"));
			libraryBtn1 = ImageIO.read(new File("res/libraryBtn1.png"));
			libraryBtn2 = ImageIO.read(new File("res/libraryBtn2.png"));
			libraryBtn3 = ImageIO.read(new File("res/libraryBtn3.png"));
			officeBtn1 = ImageIO.read(new File("res/officeBtn1.png"));
			multisalenBtn1 = ImageIO.read(new File("res/multisalenBtn1.png"));
			moodEnemy = ImageIO.read(new File("res/moodEnemy.png"));
			moneyEnemy = ImageIO.read(new File("res/moneyEnemy.png"));

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static BufferedImage getImg(String name) {
	
		if(name.equals("multisalen"))
			return multisalen;
		else if(name.equals("canteen"))
			return canteen;
		else if(name.equals("library"))
			return library;
		else if(name.equals("parkinglot"))
			return parkinglot;
		else if(name.equals("office"))
			return office;
		else if(name.equals("row"))
			return row;
		else if (name.equals("desk"))
			return desk;
		else if(name.equals("button"))
			return button1;
		else if (name.equals("canteenbutton1"))
			return canteenBtn1;
		else if (name.equals("canteenbutton2"))
			return canteenBtn2;
		else if (name.equals("canteenbutton3"))
			return canteenBtn3;
		else if (name.equals("parkingbutton1"))
			return parkingBtn1;
		else if (name.equals("parkingbutton2"))
			return parkingBtn2;
		else if (name.equals("parkingbutton3"))
			return parkingBtn3;
		else if (name.equals("librarybutton1"))
			return libraryBtn1;
		else if (name.equals("librarybutton2"))
			return libraryBtn2;
		else if (name.equals("librarybutton3"))
			return libraryBtn3;
		else if (name.equals("officebutton1"))
			return officeBtn1;
		else if (name.equals("multisalenbutton1"))
			return multisalenBtn1;
		else if (name.equals("moodEnemy"))
			return moodEnemy;
		else if (name.equals("moneyEnemy"))
			return moneyEnemy;
		else if (name.equals("closeBtn"))
			return closeBtn;
		else
			return null;	
	}
	
	
	
}
