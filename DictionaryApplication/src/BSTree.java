import java.util.ArrayList;

public class BSTree {

	Node root;
	int count;
 
	 public void insert(String w, String m, String s, String a, String e) {
	        root = insertRec(root, w, m, s,a,e);
	    }

	 // x = new Node(w, m, s, a, e, tail, tail);
	 
	 Node insertRec(Node current, String w, String m, String s, String a, String e) {
		 if (current == null) {
	            return new Node(w, m, s, a, e, null, null);
	        }
	        if (w.compareTo(current.word) < 0) {
	            current.left = insertRec(current.left,w, m, s, a, e);
	        } else if (w.compareTo(current.word) > 0) {
	            current.right = insertRec(current.right, w, m, s, a, e);
	        }
	        return current;
	 }

	 public Node search(String w) {
		 count = 0;
	        return searchRecursive(root, w);
	    }

	 public int showCount() {
		 return count;
	 }
	 
	    private Node searchRecursive(Node current, String w) {
	    	count++;
	        if (current == null) {
	            return null;
	        }
	        if (w.equals(current.word)) {
	            return current;
	        }
	        return w.compareTo(current.word) < 0
	          ? searchRecursive(current.left, w)
	          : searchRecursive(current.right, w);
	    }
	    
	
	    public Node delete(String value) {
	        return root = deleteRecursive(root, value);
	    }

	    private Node deleteRecursive(Node current, String value) {
	        if (current == null) {
	            return null;
	        }
	        if (value.equals( current.word)) {   
	            if (current.left == null && current.right == null) {
	                return null;
	            }
	            if (current.right == null) {
	                return current.left;
	            }
	            if (current.left == null) {
	                return current.right;
	            }
	            String smallestValue = findSmallestValue(current.right);
	            current.word = smallestValue;
	            current.right = deleteRecursive(current.right, smallestValue);
	            return current;
	        }
	        if (value.compareTo(current.word) < 0) {
	            current.left = deleteRecursive(current.left, value);
	            return current;
	        }
	        current.right = deleteRecursive(current.right, value);
	        return current;
	    }
	    
	    private String findSmallestValue(Node root) {
	        return root.left == null ? root.word : findSmallestValue(root.left);
	    }

	    
	    ArrayList<String> ar = new ArrayList<>();
	    public ArrayList printAll() {
	    	ar.clear();
	    	print(root);
			return ar;
		 }
	 
	    public void print(Node node) {
	        if (node != null) {
	        	print(node.left);
	           ar.add("Word : " + node.word + "\nMeaning : " + node.mean + "\nSynonyms : " + node.syns + "\nAntonyms : " + node.anty + "\nSentence : " + node.sent);
	            print(node.right);
	        }
	        
	    }
}
