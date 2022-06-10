// Approach 0=>  Accpeted Drived from next permuation , calling k times 
class Solution {
    public String getPermutation(int n, int k) {
        char ch[] =  new char[n];
        for(int i=0;i<n;i++){
            ch[i] =  (char)('1'+i);
        }
        for(int i=1;i<k;i++){
            nextPermutation(ch);
        }
        return new String(ch);
    }
    private void nextPermutation(char ch[]){
        int n  =  ch.length;
        int idx = n-1;

        while(idx > 0 &&   ch[idx-1] > ch[idx] ) idx-=1;
        idx-=1;

        if(idx!=-1){
            int idx2=  n-1;
            
            while(idx2>=0 && ch[idx2] < ch[idx] ) idx2-=1;
            if(idx2!=-1){
                char temp =  ch[idx];
                ch[idx]  =  ch[idx2];
                ch[idx2] =  temp;
            }
        }
        reverse(ch,idx+1,n-1);
    }
    
    private void reverse(char ch[] , int s, int e){
        while(s<e){
            char temp =  ch[s];
            ch[s]  =  ch[e];
            ch[e] =  temp;
            s++;
            e--;            
        }
    }
    
}
// Approach 1: Accpted O(n^2) -  
//  we are dividing our range by fixing one element each time 


import java.util.*;  
class Solution {
    public String getPermutation(int n, int k) {
        Vector<Integer> nums = new Vector<Integer>();  
        int fact = 1;
        for(int i=1;i<n;i++){
            fact =  fact*i;
            nums.add(i);        
        }
        nums.add(n);        
        // factorial one less than from n beacause 
        /*
            [1,2,3,4 ] , k =  17
            1 +( 2,3,4 ) => taking 1 as fixed , 6 permuatation possible
            2 +( 1,3,4 ) => taking 1 as fixed , 6 permuatation possible
            3 +( 1,2,4 ) => taking 1 as fixed , 6 permuatation possible
            and 17th permuation lies in this range ^  , taking 3 as fixed
                                                   
                                                   
            4 +( 1,2,3 ) => taking 1 as fixed , 6 permuatation possible
            
            next set k =  
        */

        StringBuilder sb =  new StringBuilder();
        k =  k-1;
        while(true){
            int idx = k/fact;
            sb.append( nums.get(idx) );
            nums.remove( nums.get( idx )  );
            if(nums.size()==0 ){
                break;
            }
            k =  k%fact;            
            fact =  fact / nums.size();
        }
        
        
        return sb.toString() ;
    }
}