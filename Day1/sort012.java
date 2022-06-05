"
0 to i-1 -> 0
j+1 to n-1 -> 2
i to j not clear , as data found move it to their corresponding side and move pointer 

"

class Solution {
    public void sortColors(int[] nums) {
        int n =  nums.length;
        int i=0, j=n-1;
        int itr = 0;
        while(itr<=j){
            if(nums[itr]==0 ){
                swap(nums,itr,i);
                itr++;
                i++;
            }
            else if(nums[itr]==2 ){
                swap(nums,itr,j);
                j--;
            }
            else{
             itr++;   
            }
        }
        
    }
    private void swap(int arr[],int i, int j){
        int t =  arr[i];
        arr[i] =  arr[j];
        arr[j]  =  t;
    }
}