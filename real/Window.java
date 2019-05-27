package real;


import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 1398685866265106824L;
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
		
		
		
		
		
		
		
		
	}
}
