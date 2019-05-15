package real;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

public class Handler {

	
	//The handler class is the class which handles all the GameObjects by keeping them in a list and loops through all the GameObjects, rendering and ticking them.
	//It also has the possibility to add and remove GameObjects to the list if we want which makes it a very modular game, easy to add new features and easy to remove them as well.
	
	LinkedList<GameObject> object = new LinkedList<>();
	
	public void tick() {
		for(int i=0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	public void render(Graphics g) throws IOException {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
