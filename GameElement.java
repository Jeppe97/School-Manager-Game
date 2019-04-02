import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GameElement {


	public static void main(String[] args) {


		double t0 = System.currentTimeMillis(), t1;
		int money=0;

		if((System.currentTimeMillis()-t0 >= 1000*60)){
			money++;
		}
		JFrame frame1 = new JFrame("testing some shieet");


		JPanel panel1 = new JPanel(new MigLayout("fill, insets 0, gap rel 0"));
		JPanel panel2 = new JPanel(new MigLayout("aligny 10%, alignx 0%"));
		JPanel panel3 = new JPanel(new MigLayout("fill"));
		JPanel panel4 = new JPanel(new MigLayout("aligny 50%, alignx 50%"));
		JPanel panel5 = new JPanel();

		JButton button1 = new JButton("Play");
		JButton button2 = new JButton("Options");
		JButton button3 = new JButton("Quit");
		
		JButton classroom = new JButton("Classroom");
		JButton parkingLot = new JButton("Parking Lot");
		JButton library = new JButton("Library");
		JButton office = new JButton("Office");
		JButton connector = new JButton("Connector");

		JLabel title = new JLabel("School Manager Game");
		JLabel Money = new JLabel("Money "+money);
		JLabel mood = new JLabel("Mood =D");
		Money.setFont(new Font("Verdana",1,15));

		panel1.setBackground(Color.orange);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.orange);
		panel5.setBackground(Color.green);

		panel1.add(panel2, "wrap, growx, pushx, gap 0 0, h 100, aligny 0%");

		//panel1.add(panel2, "split, growy, pushy, w 100:200:500, gap 0 0");
		panel1.add(panel4, "span, grow, push, gap 0 0");
		//panel1.add(panel5, "growy, pushy, w 100:200:500, gap 0 0, wrap");
		//panel1.add(panel3, "growx, pushx, gap 0 0, h 100:200:500");


		panel2.add(Money,"wrap");
		panel2.add(mood,"wrap");
		
		panel3.add(office,"grow");
		panel3.add(parkingLot,"grow");
		panel3.add(library,"grow");
		panel3.add(classroom,"grow");
		panel3.add(connector,"grow");
		
		panel4.add(title, "wrap, align 50%");
		panel4.add(button1, "wrap, h 75, w 500");
		panel4.add(button2, "wrap, h 75, w 500");
		panel4.add(button3, "h 75, w 500");


		panel1.add(panel3, "growx, pushx, gap 0 0, h 100, aligny 100%");		


		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().add(panel1);
		frame1.setVisible(true);





		/* Action Listeners */


		button1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				changeVis(panel1, panel2, panel3);
				Office test1 = new Office(frame1);

			}
		});

		/*
		 * 	button2.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
			  System.exit(0);
			 }
		});
		 * 
		 * */

		button3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});

		
			

	}

	public static void changeVis(JPanel panel1, JPanel panel2, JPanel panel3) {


		if(panel2.isVisible()) {
			panel1.setVisible(true);
			
			panel2.setVisible(false);
			panel3.setVisible(false);
		}
		else {
			panel1.setVisible(false);
			
			panel2.setVisible(true);
			panel3.setVisible(true);
		}


	}
	

}