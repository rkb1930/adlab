import java.util.*;

class HuffmanCoding { 

	public static void printCode(HuffmanNode root, String s) 
	{  
		if (root.left == null && root.right == null
			&& Character.isLetter(root.c)) { 

			// c is the character in the node 
			System.out.println(root.c + ":" + s); 

			return; 
		} 

		printCode(root.left, s + "0"); 
		printCode(root.right, s + "1"); 
	} 
 
	public static void main(String[] args) 
	{ 

		int n = 6; 
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
		int[] charfreq = { 5, 9, 14, 13, 16, 3 }; 

		
		PriorityQueue<HuffmanNode> q 
			= new PriorityQueue<HuffmanNode>( 
				n, new MyComparator()); 

		for (int i = 0; i < n; i++) { 
			HuffmanNode hn = new HuffmanNode(); 

			hn.c = charArray[i]; 
			hn.data = charfreq[i]; 

			hn.left = null; 
			hn.right = null; 

			
			q.add(hn); 
		} 

		
		HuffmanNode root = null; 

		while (q.size() > 1) { 

			
			HuffmanNode x = q.peek(); 
			q.poll(); 

			HuffmanNode y = q.peek(); 
			q.poll(); 

			
			HuffmanNode f = new HuffmanNode(); 

			f.data = x.data + y.data; 
			f.c = '-'; 

			 
			f.left = x; 

			 
			f.right = y; 

			
			root = f; 

			
			q.add(f); 
		} 

		printCode(root, ""); 
	} 
} 

class HuffmanNode { 

	int data; 
	char c; 

	HuffmanNode left; 
	HuffmanNode right; 
} 

class MyComparator implements Comparator<HuffmanNode> { 
	public int compare(HuffmanNode x, HuffmanNode y) 
	{ 

		return x.data - y.data; 
	} 
}

/*d:00
c:01
e:10
f:1100
a:1101
b:111 */