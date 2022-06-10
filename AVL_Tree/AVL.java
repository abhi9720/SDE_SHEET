// command : javac AVL.java && java AVL > output.txt
public class AVL {
	public static class Node{
		int data;
		Node left =null, right = null;
		
		int height =0;
		int bal = 0;
		
		public Node(int data) {
			this.data =  data;
		}
		public Node() {}
	}
	
	// @ Time Complexity : O(1)
	public static void updateHeightAndBalance(Node node) { 
		int lh =  -1,rh=-1;

		if(node.left!=null) lh =  node.left.height;
		if(node.right!=null)  rh =  node.right.height;
		
		int bal =  lh-rh;
		int height =  Math.max(lh, rh)+1;
		node.height =  height;
		node.bal =  bal;	
		
	}
	
	//@ Time Complexity : O(1)
	public static Node rightRotation(Node A) {
		Node B =  A.left;
		Node B_right = B.right;
		
		B.right =  A;
		A.left=  B_right;
		
		// because of shifting height and weight are possibly changed
		// first A then B
		// B is dependent on A		
		updateHeightAndBalance(A); 
		updateHeightAndBalance(B);
		return B;		
	}
	// @ Time Complexity : O(1)
	private static Node leftRotation(Node A) {
		Node B =  A.right;
		Node B_left =  B.left;
		
		B.left = A;
		A.right = B_left;
		
		// first A then B
		// B is dependent on A
		updateHeightAndBalance(A);
		updateHeightAndBalance(B);
		return B;
	}
	// @ Time Complexity : O(1)
	public static Node getRotation(Node node) {
		updateHeightAndBalance(node);
		if(node.bal==2) { // ll or lr 
			if(node.left.bal==1) { // ll
				return rightRotation(node);				
			}
			else {// lr
				node.left = leftRotation(node.left);
				return rightRotation(node);				
			}			
		}
		else if(node.bal==-2) { // rr or rl
			if(node.right.bal==-1) {// rr
				return leftRotation(node);
			}
			else { // rl
				node.right  =  rightRotation(node.right);
				return leftRotation(node);
			}		
		}
		return node;		
	}
	//@ Time Complexity : O(logN )
	public static Node addData(Node root, int data ) {
		
		if(root==null) {
			return new Node(data);
		}
			
		if(  data < root.data) {
			root.left =  addData(root.left, data);
		}
		else if(data > root.data) {
			root.right =  addData(root.right, data);
		}
		return getRotation(root);
	}
	//@ Time Complexity : O(logN )	
	private static Node removeData(Node root,int data) {
		
		if(data < root.data) {
			root.left =  removeData(root.left, data);
		}
		else if(data > root.data) {
			root.right =  removeData(root.right, data);
		}
		else {
			// left , null || null , right || null , null
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else {
				Node rightNode =  root.right;
				while(rightNode.left!=null) {
					rightNode = rightNode.left;
				}
				root.data =  rightNode.data;
				root.right =  removeData(root.right,rightNode.data);				
			}					
		}
		return getRotation(root);
	}
	
	
	public static void display(Node node) {
		if(node==null) return ;
		
		StringBuilder sb = new StringBuilder();
		if(node.left!=null) {
			sb.append(node.left.data+" <-  ");
		}
		else {
			sb.append(". <-  ");
		}
		
		sb.append(node.data+" ["+node.bal+","+node.height+"]");
		
		if(node.right!=null) {
			sb.append("  -> "+node.right.data);
		}
		else {
			sb.append("  -> .");
		}
		System.out.println(sb);
		
		display(node.left);
		display(node.right);
		
	}	
	public static void solve() {
		int arr[] =  {10,20,30,40,50,60,70,80,90,100};
		Node root=null;
		for(int ele : arr) {			
			root =  addData(root, ele);			
		}		
		display(root);
		
		System.out.println("\n-------- After removing 80 ----------------");
		removeData(root, 80);
		display(root);
	}
	
	public static void main(String[] args) {
		solve();
	}
}
