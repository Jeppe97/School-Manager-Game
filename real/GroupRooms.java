package real;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class GroupRooms extends GameObject{

	public GroupRooms(int x, int y, ID id) {
		super(x, y, id);

		groupRooms = 500;
		
	}

	public void tick() {
		groupRoomString = Integer.toString(groupRooms);
		
	}

	public void render(Graphics g) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
