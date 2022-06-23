/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class pair{
    TreeNode node;
    int idx ;
    pair(TreeNode  node, int index){
        this.node =  node;
        this.idx =  index;
    }
}
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;     
        Queue<pair> q =  new LinkedList<>();
        // Doing indexxing in CBT tree format 
        // left child index =  2*pidx+1 
        // right child index  =  2*pidx+2
        q.add(new pair(root,0));
        while(q.size() > 0 ){            
            int size =  q.size();
            int max = 0, min = 0;   
            for(int i=0;i<size;i++){
                pair peek =  q.poll();
                TreeNode node = peek.node;
                int idx = peek.idx;
                
                // we want max and min on that level index, 
                // but we intializze max and min by 0 
                // thats why instead of max , min function we did in this way 
                if(i==size-1){
                    max =  idx;
                }
                if(i==0){
                    min  =  idx;
                }
                
                if(node.left!=null){
                    q.add(new pair(node.left,2*idx+1) );
                }
                if(node.right!=null){
                    q.add(new pair(node.right,2*idx+2) );
                }                
            }
            
            width =  Math.max(max-min+1,width);
        }
        return width;
    }
   
}

