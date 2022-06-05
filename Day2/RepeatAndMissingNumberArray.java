"
1). xor all a[i] -> x
2). x ^ (1^2^.....n)
3). x^y =  num, xor of missing and duplicate number 
4). partition arr on the basis of rsb
5). and also partition (1,2,3...n)  by this rsb 
6). to know which is duplicate or missing, linearly iterate over the array again

"
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int xor =  0, n =  A.size() ;
        
        for(int ele : A) xor^=ele;
        for(int i=1;i<=n;i++) xor^=i;
        int rsb  =  (xor & -xor);
        int x = 0,y=0;
        for(int ele : A){
            if((rsb&ele)==0){
                x^=ele;
            }
            else{
                y^=ele;
            }
        }

        for(int i=1;i<=n;i++){
             if((rsb&i)==0){
                x^=i;
            }
            else{
                y^=i;
            }
        }
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int ele : A){
            if(ele==x){
                ans.add(x);
                ans.add(y);
                return ans;
            }                    
        }
        ans.add(y);
        ans.add(x);
        return ans;
        
    }
}