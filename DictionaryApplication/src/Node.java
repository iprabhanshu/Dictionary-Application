
public class Node{

	String word;
	String  mean;
    String syns;
    String anty;
    String sent;
	Node left;
	Node right;
	
	Node(String w, String m, String s, String a, String e, Node ll, Node rr) { 
		  word = w;
		  mean = m;
          syns = s;
          anty = a;
          sent = e;
		  left = ll; 
		  right = rr; 
		 }
	
	public String readWord(){
		return word;
		}
	
	public String readMean(){
		return mean;
		}
	
	public String readSyns(){
		return syns;
		}
	
	public String readAnty() {
		return anty;
	}
	
	public String readSent() {
		return sent;
	}

	
	
}
