package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TestGUI {

	static GraphicsConfiguration gc;
	public static void main(String[] args) throws IOException {

		File myFile = new File("C:/Users/gusta/Downloads/abc.jpg");
		BufferedImage myImage = ImageIO.read(myFile);
		ImageIcon icon = new ImageIcon("C:/Users/gusta/Downloads/abc.jpg");
		
		BufferedImage buttonIcon = ImageIO.read(myFile);
		/*
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
*/
		JFrame frame = new JFrame(gc);		
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JButton button = new JButton();
		//frame.setContentPane(new ImagePanel(myImage));
	
		label.setIcon(icon);
		frame.setLayout(new FlowLayout());			//dimension of panel requires a layout
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		button.setPreferredSize(new Dimension(300,200));
		//button.setBorder(BorderFactory.createEmptyBorder());				//this and row 49 removes indications of something being a button
		//button.setContentAreaFilled(false);								
		
		
		
		panel.setBackground(Color.red);
		//panel.setPreferredSize(new Dimension(300,200));		//does not work without a layout; see above
		//panel.add(label);					//does not scale image
		
		panel.setPreferredSize(new Dimension(200,200));
		frame.getContentPane().add(panel);
		frame.getContentPane().add(button);
		
		
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(panel.isVisible()) {
		    		panel.setVisible(false);
		    	}
		    		
		    	else if(!panel.isVisible())
		    		panel.setVisible(true);
		    }
		});
		
		
		
		
		frame.setVisible(true);
		
		
		
		/*
		frame.getContentPane().add(panel);
		//frame.setUndecorated(true);		will be used later on
		frame.setLocation(0,0 );
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setAlwaysOnTop(true);
		*/
		
		

	}



}

