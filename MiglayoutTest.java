
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MiglayoutTest {

	public static void main(String[] args) {
		
		JPanel panel1 = new JPanel(new MigLayout("fill, insets 0, gap rel 0"));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel(new MigLayout("aligny 50%, alignx 95%"));
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel newScene = new JPanel(new MigLayout("fill, insets 0, gap 0 0"));
		JPanel newScene2 = new JPanel(new MigLayout("aligny 5%, alignx 50%"));
		JPanel newScene3 = new JPanel();

		JFrame frame1 = new JFrame("testing some shieet");
		JButton button1 = new JButton("Next Scene");
		JButton button2 = new JButton("Previous Scene");
		JTextField textField = new JTextField(10);
		JTextField textField2 = new JTextField(20);
		JTextField textField3 = new JTextField(15);
		JTextField textField4 = new JTextField(25);
		
		panel1.setBackground(Color.blue);
		panel2.setBackground(Color.red);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.black);
		panel5.setBackground(Color.green);

		panel1.add(panel2, "split, growy, pushy, w 100:200:500, gap 0 0");
		panel1.add(panel4, "span, grow, push, gap 0 0");
		panel1.add(panel5, "growy, pushy, w 100:200:500, gap 0 0, wrap");
		panel1.add(panel3, "growx, pushx, gap 0 0, h 100:200:500");
		
		panel3.add(button1, "h 75, w 150");
		
		
		
		newScene.setBackground(Color.YELLOW);
		newScene2.setBackground(Color.blue);
		newScene3.setBackground(Color.red);
		
		newScene.add(newScene2, "grow, push, gap 0");
		newScene.add(newScene3, "grow, push, gap 0");
		
		newScene2.add(button2, "h 75, w 150");
		

		
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().add(panel1);
		frame1.setVisible(true);
	
		button1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(panel1.isVisible()) {
		    		panel1.setVisible(false); //hides the panel
		    		frame1.remove(panel1);	//removes the panel from memory
		    		frame1.getContentPane().add(newScene);
		    		newScene.setVisible(true);
		    		
		    	}
		    }
		});
		button2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(newScene.isVisible()) {
		    		newScene.setVisible(false); //hides the panel
		    		frame1.remove(newScene);	//removes the panel from memory
		    		frame1.getContentPane().add(panel1);
		    		panel1.setVisible(true);
		    		
		    		
		    	}
		    }
		});
	
	
	}
	
	
	
	
	
	
}