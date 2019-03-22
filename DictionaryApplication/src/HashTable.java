
public class HashTable {

	int count;
	 public String hash(String w){ 
		 return w;
		 }
		
     private HNode[] head=new HNode[20];
     
	    public  HashTable(){for(int i=0;i<20;i++)head[i]=null;}

		public  void insert(String w, String m, String s, String a, String e)
	        {      HNode temp = new HNode(w,m,s,a,e);
	        	   HNode.nodearr[HNode.l]  = temp;
	        	   HNode.l++;
	               String index = hash(w);
	               temp.next=head[index.length()];
			       head[index.length()]=temp;
			       }


		public  HNode search(String w) {     
			count = 0;
			String index=hash(w);
			HNode temp=head[index.length()];	 
			boolean found=false;
			while(temp!=null&&found==false) {
				count++;
				   if (temp.word.equals(w)){found=true; break;}
	               temp=temp.next;
	        }
         return temp;
         }
		
		 public int showCount() {
			 return count;
		 }
		
		 public boolean delete(String w) {
				String index=hash(w);
				if(this.search(w).equals(null)) {
					return false;
				}
				HNode temp=head[index.length()];
				HNode remove=temp;
				if (temp.word.equals(w)) {
					head[index.length()]=temp.next;
				 } else {
					while(temp!=null&&temp.word!=w) {
					   remove=temp;
		               temp=temp.next;
					}	
					remove.next = temp.next;
				   }
				return true;
			}
	
}
