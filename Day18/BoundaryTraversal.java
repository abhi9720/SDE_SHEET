
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> bound =  new ArrayList<>();
        if(node==null) return bound

	    bound.add(node.data);

        leftBoundary(node.left,bound);
        
        addLeave(node.left,bound); // make call two time so root not added twice 
        addLeave(node.right,bound);
        
        rightBounary(node.right,bound);
        return bound;
	}
	private void leftBoundary(Node node , ArrayList<Integer> bound){
	    while(node!=null){
	    if(node.left!=null || node.right!=null){
	         bound.add(node.data);
	    }
	        if(node.left==null) node = node.right;
	        else node=  node.left;
	    }
	}
	private void addLeave(Node node , ArrayList<Integer> bound){
	    if(node==null) return ;
	    if(node.left==null && node.right==null){
	        bound.add(node.data);
	        return ;
	    }
	    addLeave(node.left,bound);
	    addLeave(node.right,bound);
	}
	
	private void rightBounary(Node node , ArrayList<Integer> bound){
	    if(node==null) return ;
	    
	    if(node.right==null) rightBounary(node.left,bound);
	    else rightBounary(node.right,bound);
	    if(node.left!=null || node.right!=null){
	         bound.add(node.data);
	    }
	}
	
	
	
	
}
