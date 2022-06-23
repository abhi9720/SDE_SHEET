
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr =  root;
        while(curr!=null){
            TreeNode left =  curr.left;
            if(left==null){
                // inorder here
                ans.add(curr.val);
                curr =  curr.right;
            }
            else {
                // move to extrme right child
                while(left.right!=null && left.right!=curr){
                    left =  left.right;
                }
                if(left.right==null){
                    // create thread 
                    left.right =  curr;
                    curr =  curr.left;
                }
                else{
                    // inorder here
                    ans.add(curr.val);
                    left.right =  null;
                    curr =  curr.right;
                }
            }
        }
        return ans;
        
    }
}