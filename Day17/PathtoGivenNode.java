
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer>  ans =  new ArrayList<>();
        dfs(A,B,ans);
        return ans;
    }
    private boolean dfs(TreeNode A, int B,ArrayList<Integer>  ans ){
        if(A==null) return false;
        if(A.val==B){ 
            ans.add(B);
            return true;
        }
        ans.add(A.val);
        if(dfs(A.left,B,ans)  || dfs(A.right,B,ans)){
           return true; 
        }                
        ans.remove(ans.size()-1 );
        return false;
    }
}
