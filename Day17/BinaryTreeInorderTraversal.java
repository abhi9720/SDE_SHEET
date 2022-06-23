//1. recusive 
//2. using stack + pair class to maintain state of node 
//3. using single stack only 


"----------------------------------------"


// 2. using stack + pair class to maintain state of node 
class pair{
    TreeNode node;
    int state;
    public pair(TreeNode node, int state){
        this.node =  node;
        this.state =  state;
    }
        
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<pair> stk =  new Stack<>();        
        List<Integer> li =  new ArrayList<>();
        if(root==null) return li;
        stk.push(new pair(root,0) );
        while(stk.size()!=0 ){
            pair peek =  stk.peek();
            if(peek.state== 0 ){
                if(peek.node.left!=null){
                    stk.push(new pair(peek.node.left,0));
                }
                peek.state+=1;
            }
            else if(peek.state==1){
                li.add(peek.node.val);
                peek.state+=1;
            }else if(peek.state==2) {
                
                if(peek.node.right!=null){
                    stk.push(new pair(peek.node.right,0));
                }
                peek.state+=1;
            }
            else{
                stk.pop();
            }            
        }
        return li;
        
    }
}



// 3. using single stack only



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk =  new Stack<>();
        List<Integer> li =  new ArrayList<>();
        TreeNode temp =  root;
        while(temp!=null){
            stk.push(temp);
            temp = temp.left;            
        }
        
        while(!stk.isEmpty() ){
            TreeNode p =  stk.pop();
            li.add(p.val);
            temp  = p.right;
            while(temp!=null){
                stk.push(temp);
                temp =  temp.left;
            }                
        }
        return li;                
    }
}