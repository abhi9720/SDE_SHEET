"
1. a[i-1] < a[i] , mark idx1 = i-1 break, iterate n-1 to 0
2. a[j] > a[idx1] mark idx2 =  j break , iterate n-1 to > idx1
3. swap (a[idx1], a[idx2]) 
4. reverse(idx1+1 , n-1)
Note : if idx2 == n-1 , then reverse(arr,0,n-1) and return no Swapping

Intuition: 1 3 5 4 2, from backside it always increasing from the backside
1,3 is a prefix, we want to increase this slope as minimal as possible 


"

class Solution {
    public void nextPermutation(int[] nums) {
        int n  =  nums.length;
        int idx =  n;
        for(int i=n-1;i>0;i--){
            if( nums[i-1] < nums[i] ){
                idx =  i-1;
                break;
            }
        }
        
        if(idx==n) {
            reverse(nums,0,n-1);
            return ;
        }
        
        int idx1 =  n;
        for(int j=n-1;j>idx;j--){            
            if( nums[j] > nums[idx] ){
                idx1 =  j;    
                break;
            }
        }                       
        
        int swap =  nums[idx];
        nums[idx] =  nums[idx1];
        nums[idx1] =  swap;
        reverse(nums,idx+1,n-1);
                    
    }
    
    private void reverse(int nums[], int i , int j){
        while(i<j){
            int t = nums[i];
            nums[i] =  nums[j];
            nums[j] =  t;
            i++;
            j--;
        }
    }
}