// make call of child , in faith they will return their height
// then root will do his work 

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        
        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right) );
        
    }
}