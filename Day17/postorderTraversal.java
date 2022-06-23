//1. recusive 
//2. using stack + pair class to maintain state of node 
//3. using single stack only 

"--------------------------------------------------------"

//3. using single stack only 
// Implementation 1 moving left to right 

class Solution {
    // moveing left to right
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.addFirst(curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }
}


// Implementation 2 moving right to left

// preorder traversal  right root left => is equal to 
// reverse of post order traversal left right root
// i.e preorder from right to left equal to reverse of postorder from lef to rigth
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk =  new Stack<>();
        LinkedList<Integer> li =  new LinkedList<>();
        
        TreeNode itr =  root;
        while(itr!=null  || !stk.isEmpty() ){
            if(itr==null){
                itr =  stk.pop().left;
            }
            else{
                li.addFirst(itr.val);
                stk.push(itr);
                itr =  itr.right;
            }
        }
        return li;
    }
}