package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MultiPOP extends GameObject {

	public MultiPOP(int x, int y, ID id) {
		super(x, y, id);
	}
	
	public MultiPOP(Game game, int x, int y, ID id) {
		super(x,y,id);
		
	}

	public void tick() {
		//Is empty because we don't have anything that needs to tick in this class.
	}

	@Override
	public void render(Graphics g) throws IOException {
		g.setColor(Color.blue);
		g.fillRect((Game.WIDTH/2)-250, (Game.HEIGHT/2)-250, 500, 500);
		g.setColor(Color.red);
		g.drawRect((Game.WIDTH/2)+210, (Game.HEIGHT/2)-250, 40, 40);
		g.setColor(Color.yellow);
	
		
		BufferedImage img = null;
		img = ImageIO.read(new File("res/btn.png"));
		g.drawImage(img, (Game.WIDTH/2)-230, (Game.HEIGHT/2)+150, null);
		
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
