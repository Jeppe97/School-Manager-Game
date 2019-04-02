package test;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Office {
	
	JPanel officePanel = new JPanel(new MigLayout("fill, insets 0, gap rel 0"));
	JButton testbtn = new JButton("Next Scene");

	
	public Office(JFrame frame1) {

		officePanel.setBackground(Color.cyan);
		frame1.getContentPane().add(officePanel);
		

	}
	
	
	public static void changeVis() {
		
		
		
		
	}
	
	
	
}
