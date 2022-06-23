//1. recusive 
//2. using stack + pair class to maintain state of node 
//3. using single stack only 


"----------------------------------------"


//3. using single stack only 
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> li = new ArrayList<>();
        TreeNode temp = root;
        while (temp != null) {
            li.add(temp.val);
            stk.push(temp);
            temp = temp.left;
        }

        while (stk.size() != 0) {
            TreeNode p = stk.pop();

            temp = p.right;
            while (temp != null) {
                li.add(temp.val);
                stk.push(temp);
                temp = temp.left;
            }
        }
        return li;
    }
}
