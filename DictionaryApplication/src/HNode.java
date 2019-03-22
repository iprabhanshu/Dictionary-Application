
public class HNode implements Iterator, Container{

	String word;
	String mean;
    String syns;
    String anty;
    String sent;
	HNode next;
	static int l=0;
	private int index = 0; 
	static HNode[] nodearr = new HNode[10];
	
	HNode(String w, String m, String s, String a, String e)
		{ 
		word = w;
		mean = m;
        syns = s;
        anty = a;
        sent = e;
		next = null;
		 	
	}
	HNode(){};
	
	public String readKey(){return word;}
	public String readName(){return mean;}
	public String readAge(){return syns;}
	public String readAnty() {return anty;}
	public String readSent() {return sent;}

	@Override
	public Iterator getIterator() {
        return this;
	}
	@Override
	public boolean hasNext() {
		if(index < l){
            return true;
         }
         return false;
	}
	@Override
	public Object next() {
		if(this.hasNext()) {
			return nodearr[index++];
		}
		return null;
         
	}
	
}
