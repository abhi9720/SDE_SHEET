"
trick test case : 
3
0 0 0 0 0 0 0 0 0
if no one know each other 
if there are count of such people equal to n-1 then there is no celebrity
"

class Solution
{ 
    
    int celebrity(int M[][], int n){      
      Stack<Integer> stk =  new Stack<>();
      for(int i=0;i<n;i++){
        stk.push(i);
      }
      int count = 0;
      while(stk.size()>1 ){
        int p1 =  stk.pop();
        int p2 =  stk.pop();
        // if p1 knows p2 than p1 cannot be celebrity
        // if p2 knows p1 than  p2 cannot be celebrity
        // if p1 and p2 don't know any each other p1 cannot be celebrity 
        // as celebrity is know by every one 

        if(M[p1][p2]==1){
          stk.push(p2);
        }
        else  {
          stk.push(p1);
          if(M[p1][p2]==0 && M[p2][p1]==0){
                count++;
          }
        }
      }

      // atlast make sure remained person is celebrity 
      int p =  stk.peek();
      for(int i=0;i<n;i++){
        if(M[p][i]==1) return -1;
      }
      
      if(count==n-1) return -1;
      return p;    	 
    }
}