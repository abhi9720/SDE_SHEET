    import java.util.*;
    public class Solution {

        public static void sortStack(Stack<Integer> stk) {
            if(stk.size() == 1 || stk.size()==0 ) return ;
            int ele=  stk.pop();
            sortStack(stk);
            if(stk.peek() < ele ){
                stk.push(ele);
            }
            else{            

                correctPosition(stk,ele);            
            }
        }

        private static void correctPosition(Stack<Integer> stk , int num){
            if(stk.empty()){
                stk.push(num);
                return;
            }

            if(stk.peek() < num ){
                stk.push(num);
                return ;
            }
            int ele =  stk.pop();
            correctPosition(stk,num);
            stk.push(ele);        
        }    
    }