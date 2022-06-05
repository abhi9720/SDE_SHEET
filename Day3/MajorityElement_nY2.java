"Keep one variable ele, initialize with 0th index, and count  =1 
if a similar element found increment else decrement,
if the count goes to 0 then update ele 

"
class Solution {
    public int majorityElement(int[] nums) {
        int ele =  nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0) {
                ele =  nums[i];
                count=1;
            }
            else if(ele ==  nums[i] ) count+=1;
            else count-=1;
        }
        return ele;
    }
}