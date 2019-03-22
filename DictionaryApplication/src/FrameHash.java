import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameHash extends JFrame implements ActionListener{

	private JLabel l0 = new JLabel("Dictionary");
	private JLabel l1 = new JLabel("Word");
	private JLabel l2 = new JLabel("Meaning");
	private JLabel l3 = new JLabel("Synonyms");
	private JLabel l4 = new JLabel("Antonyms");
	private JLabel l5 = new JLabel("Sentence");
	private static JTextField t1=new JTextField("",9);
	private static JTextField t2=new JTextField("",9);
	private static JTextField t3=new JTextField("",9);
	private static JTextField t4 = new JTextField("",9);
	private static JTextField t5 = new JTextField("",9);

	private JButton b1=new JButton("Insert");
	private JButton b2=new JButton("Search");
	private JButton b3=new JButton("Close");
	private JButton b4=new JButton("Iterate");
	private JButton b5=new JButton("Delete");
	private HashTable tree=new HashTable();//This is new
	private int current=0; //This is new

	public FrameHash(String s){
		super(s);
		
		/*tree.insert("Adore","respect","love");
		tree.insert("Grace","smoothness","finesse");
		tree.insert("Polite","behaviour","courteous");*/
		tree.insert("Adore","Respect","Love","Hate","I adore you");
		tree.insert("Grace","Smoothness","Finesse","Inelegant","Slender and Graceful");
		tree.insert("Polite","Behaviour","Courteous","Savage","Polite Society");
		Container content=getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		l0.setBounds(203, 13, 88, 27);
		l0.setFont(f);
		getContentPane().setLayout(null);
		content.add(l0);b3.setBounds(40, 354, 398, 25);
content.add(b3);
l1.setBounds(12, 44, 105, 27);
getContentPane().add(l1);
l1.setFont(f);
t1.setBounds(89, 47, 375, 27);
getContentPane().add(t1);
l2.setBounds(40, 87, 69, 27);
getContentPane().add(l2);
t2.setBounds(121, 87, 317, 27);
getContentPane().add(t2);
l3.setBounds(40, 129, 105, 27);
getContentPane().add(l3);
t3.setBounds(121, 129, 317, 27);
getContentPane().add(t3);
l4.setBounds(40, 169, 69, 27);
getContentPane().add(l4);
t4.setBounds(121, 169, 317, 27);
getContentPane().add(t4);
l5.setBounds(40, 209, 63, 27);
getContentPane().add(l5);
t5.setBounds(121, 209, 317, 27);
getContentPane().add(t5);
		b1.setBounds(40, 262, 184, 27);
		getContentPane().add(b1);
		b2.setBounds(254, 262, 184, 27);
		getContentPane().add(b2);
		b4.setBounds(254, 312, 184, 27);
		getContentPane().add(b4);
		b5.setBounds(40, 312, 184, 27);
		getContentPane().add(b5);
		b5.addActionListener(this);
		b4.addActionListener(this);
		b2.addActionListener(this);
		b1.addActionListener(this);b3.addActionListener(this);
		   //Horiz , Vert
		setSize(518,439);    setVisible(true);}
	
	/*public static void main(String[] args) {
	HNode hn = new HNode("Hello","Greet","Hi","Bye","hello there");
	HNode.nodearr[HNode.l]  = hn;
	HNode.l++;

	Iterator iter = hn.getIterator();
	while(iter.hasNext()) {
		HNode node = (HNode) iter.next();
		System.out.println(node.word + "-> " + node.mean+ "-> " + node.syns+ "-> " + node.anty+ "-> " + node.sent);
	}
	}*/
		 

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
	 		     String id= t1.getText();
	 		     String nm= t2.getText();
	 		     String ag= t3.getText();
	 		     String at = t4.getText();
	 		     String se = t5.getText();
	 		     tree.insert(id, nm, ag, at, se);
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
	    	 //int id=Integer.parseInt(t1.getText());
	    	 String id = t1.getText();
	    	 HNode temp=tree.search(id);
	    	 if (temp==null){ 
	    		 JOptionPane.showMessageDialog(null, "Not Found");
	    		 t2.setText("");
	    	     t3.setText("");
	    	     t4.setText("");
	    	     t5.setText("");
	    	 }
	    	 else       { t1.setText(""+temp.readKey());
	    	              t2.setText(""+temp.readName());
	    	              t3.setText(""+temp.readAge());
	    	              t4.setText(""+temp.readAnty());
	    	              t5.setText(""+temp.readSent());
	    	              JOptionPane.showMessageDialog(null, "Step Count Performance:  " + tree.showCount());
	    	            }
	     	}
	     if (target==b3)
	     	{
	    	 t1.setText("");
	    	 t2.setText("");
    	     t3.setText("");
    	     t4.setText("");
    	     t5.setText("");
	    	 this.setVisible(false);
	      	 MyFrame1 main = MyFrame1.getInstance();
	      	 main.setVisible(true);
	    	 //this.setVisible(false);
	     	}
	     
	     if(target==b4) {
	    	 HNode hn = new HNode();
	    	 Iterator iter = hn.getIterator();
	    		while(iter.hasNext()) {
	    			HNode node = (HNode) iter.next();
	    			JOptionPane.showMessageDialog(null, "ITERATOR\n " + "Word : " + node.word + "\nMeaning :  " + 
	    			node.mean + "\nSynonyms : " + node.syns + "\nAntonyms : " + node.anty + "\nSentence : " + node.sent);
	    			
	    		}
	     }
	     if(target==b5) {
	    	 
	    	 String id = t1.getText();
	    	 boolean temp=tree.delete(id);
	    	 t1.setText("");
	    	 t2.setText("");
    	     t3.setText("");
    	     t4.setText("");
    	     t5.setText("");
    	     JOptionPane.showMessageDialog(null, "Deleted Successfully");
	     }
		
	}
	
}
