package real;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MultiPOP extends GameObject {
	
	private Game game;

	public MultiPOP(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}
	
	public MultiPOP(Game game, int x, int y, ID id) {
		super(x,y,id);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) throws IOException {
		g.setColor(Color.blue);
		g.fillRect((Game.WIDTH/2)-250, (game.HEIGHT/2)-250, 500, 500);
		g.setColor(Color.red);
		g.drawRect((game.WIDTH/2)+210, (game.HEIGHT/2)-250, 40, 40);
		g.setColor(Color.yellow);
	
		
		BufferedImage img = null;
		img = ImageIO.read(new File("C:\\Users\\gusta\\eclipse-workspace\\School Manager Game\\src\\btn.png"));
		g.drawImage(img, (game.WIDTH/2)-230, (game.HEIGHT/2)+150, null);
		
		
	}

}
