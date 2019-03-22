import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class MyFrame1 extends JFrame implements ActionListener {

    private JLabel l0 = new JLabel("Dictionary Application");
	private JButton b1=new JButton("Dictionary Binary Search Tree");
	private JButton b2=new JButton("Dictionary Hash Tab");
	private JButton b3=new JButton("Exit");
	
	private static MyFrame1 single;
	private static boolean created = false;
	
	public MyFrame1(String s) {
		super(s);
		getContentPane().setForeground(Color.GRAY);
		
		Container content = getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		getContentPane().setLayout(null);
		l0.setBounds(91, 5, 200, 28);
		l0.setFont(new Font("Serif", Font.BOLD, 21));  
		content.add(l0);
		b3.setBounds(54, 213, 275, 29);
		getContentPane().add(b3);
		b3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b2.setBounds(54, 136, 275, 29);
		getContentPane().add(b2);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b1.setBounds(54, 60, 275, 29);
		getContentPane().add(b1);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		b1.addActionListener(this);
		b2.addActionListener(this);		
		b3.addActionListener(this);
		   //Horiz , Vert
		setSize(400,350);    
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		
		if(target==b1) {
			FrameBinary f = new FrameBinary("Frame Binary");
			f.setVisible(true);
      		this.setVisible(false);

		}
		if(target==b2) {
			FrameHash f = new FrameHash("Frame Hash");
			f.setVisible(true);
      		this.setVisible(false);
		}
		if(target==b3) {
			System.exit(0);
		}
	}
	
	public static MyFrame1 getInstance() {
		if(!created) {
			single = new MyFrame1("Dictionary Application");
		}
		return single;
	}
}
