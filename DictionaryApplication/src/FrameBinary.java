import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameBinary extends JFrame implements ActionListener{

	private JLabel l0 = new JLabel("Dictionary");
	private JLabel l1 = new JLabel("Word");
	private JLabel l2 = new JLabel("Meaning");
	private JLabel l3 = new JLabel("Synonyms");
	private JLabel l4 = new JLabel("Antonyms");
	private JLabel l5 = new JLabel("Sentence");
	private JTextField t1=new JTextField("",9);
	private JTextField t2=new JTextField("",9);
	private JTextField t3=new JTextField("",9);
	private JTextField t4 = new JTextField("",9);
	private JTextField t5 = new JTextField("",9);

	private JButton b1=new JButton("Insert");
	private JButton b2=new JButton("Search");
	private JButton b3=new JButton("Close");
	private JButton b4 = new JButton("Delete");
	private JButton b5 = new JButton("Iterator");
	private BSTree tree=new BSTree();//This is new
	private int current=0; //This is new
	
	
	
	public FrameBinary(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		tree.insert("Adore","Respect","Love","Hate","I adore you");
		tree.insert("Grace","Smoothness","Finesse","Inelegant","Slender and Graceful");
		tree.insert("Polite","Behaviour","Courteous","Savage","Polite Society");

		Container content=getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		l0.setBounds(139, 13, 88, 27);
		l0.setFont(f);
		getContentPane().setLayout(null);
		content.add(l0);b3.setBounds(72, 347, 298, 25);
content.add(b3);
l1.setBounds(12, 53, 105, 27);
getContentPane().add(l1);
l1.setFont(f);
t1.setBounds(72, 56, 298, 27);
getContentPane().add(t1);
l2.setBounds(22, 93, 82, 27);
getContentPane().add(l2);
t2.setBounds(111, 93, 215, 27);
getContentPane().add(t2);
l3.setBounds(22, 133, 82, 27);
getContentPane().add(l3);
t3.setBounds(110, 133, 216, 27);
getContentPane().add(t3);
l4.setBounds(22, 173, 63, 27);
getContentPane().add(l4);
t4.setBounds(111, 173, 215, 27);
getContentPane().add(t4);
l5.setBounds(22, 213, 63, 27);
getContentPane().add(l5);
t5.setBounds(111, 213, 215, 27);
getContentPane().add(t5);
		b1.setBounds(72, 253, 129, 27);
		getContentPane().add(b1);
		b2.setBounds(241, 253, 129, 27);
		getContentPane().add(b2);
		b4.setBounds(72, 299, 129, 25);
		
		getContentPane().add(b4);
		b5.setBounds(241, 299, 129, 25);
		
		getContentPane().add(b5);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		   //Horiz , Vert
		setSize(405,446);    setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target=e.getSource();
	 	if (target==b1)
	 		{     
	 		if(t1.getText().equals("")) {
	 			JOptionPane.showMessageDialog(null, "Please enter some word");
	 		}
	 		else {
	 		     String word = t1.getText();
	 		     String mean = t2.getText();
	 		     String syns = t3.getText();
	 		     String anty = t4.getText();
	 		     String sent = t5.getText();
	 		     tree.insert(word, mean, syns, anty, sent);
	 		     JOptionPane.showMessageDialog(null, "Word added to Dictionary");
	 		     t1.setText("");
	 		     t2.setText("");
	    	     t3.setText("");
	    	     t4.setText("");
	    	     t5.setText("");
	 		}
	 		
	         }

	     if (target==b2)
	     	{
	    	 String id = t1.getText();
	    	 Node temp=tree.search(id);
	    	 
	    	 if (temp==null){  
	    		 JOptionPane.showMessageDialog(null, "Not Found");
	    		 t2.setText("");
	    	     t3.setText("");
	    	     t4.setText("");
	    	     t5.setText("");
	    	                   }
	    	 else       { t1.setText(""+temp.readWord());
	    	              t2.setText(""+temp.readMean());
	    	              t3.setText(""+temp.readSyns());
	    	              t4.setText(""+temp.readAnty());
	    	              t5.setText(""+temp.readSent());
	    	              JOptionPane.showMessageDialog(null, "Step Count Performance:  " + tree.showCount());
	    	            }
	     	}
	     if (target==b3)
	     	{
	    	 this.setVisible(false);
	      	 MyFrame1 main = MyFrame1.getInstance();
	      	 main.setVisible(true);
	     	}
	     
	     if(target==b4) {
	    	 String id = t1.getText();
	    	 Node temp=tree.delete(id);
	    	 t1.setText("");
	    	 t2.setText("");
    	     t3.setText("");
    	     t4.setText("");
    	     t5.setText("");
    	     JOptionPane.showMessageDialog(null, "Deleted Successfully");
	    	 
	     }
	     
	     if(target==b5) {
	    	ArrayList ar = tree.printAll();
	    	 java.util.Iterator iterator = ar.iterator();
	    	 while(iterator.hasNext()) {
	    		 JOptionPane.showMessageDialog(null, "Iterator\n" + iterator.next());
	    	 }

	      }
	}
}
