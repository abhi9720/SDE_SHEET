public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans =  new ArrayList<>();
        Stack<Integer> stk = new Stack<>();        
        for(int ele :  A){
            while(!stk.empty() && stk.peek() >= ele ){
                stk.pop();
            }
            if(stk.size()==0){
                ans.add(-1);
            }
            else{
                ans.add(stk.peek() );
            }
            stk.push(ele);
        }
        return ans;
    }
}
