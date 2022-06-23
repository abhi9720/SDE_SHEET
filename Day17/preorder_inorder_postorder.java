import java.util.*;

public class Solution {
    static class pair{
        BinaryTreeNode<Integer> node;
        int state ;
        public pair(BinaryTreeNode<Integer> node , int state){
            this.node =  node;
            this.state =  state;
        }    
    }
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans =  new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        if(root==null) return ans;
        Stack<pair> stk =  new Stack<>();
        stk.push(new pair(root,0) );

        while(stk.size() > 0 ){
            pair peek =  stk.peek();
            if(peek.state==0){
                // preorder 
                ans.get(1).add(peek.node.data);
                peek.state+=1;
                if(peek.node.left!=null){
                    stk.push(new pair(peek.node.left,0) );
                }
            }
            else if(peek.state==1){
                // inorder here
                ans.get(0).add(peek.node.data);
                peek.state+=1;
                if(peek.node.right!=null){
                    stk.push(new pair(peek.node.right,0) );
                }
            }
            else {
                // postorder 
                ans.get(2).add(peek.node.data);
                stk.pop();                
            }
        }
        return ans;

    }
}
