class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk =  new Stack<>();
        
        for(char ch : s.toCharArray() ){
            if(ch=='(' || ch=='[' || ch=='{'){
                stk.push(ch);
            }
            else{
                if(stk.size()==0)  return false;
                char peek =  stk.pop();
                if(ch=='}' && peek!='{' ) return false;
                if(ch==')' && peek!='(' ) return false;
                if(ch==']' && peek!='[' ) return false;
            }
        }
        return stk.size()==0;
    }
}