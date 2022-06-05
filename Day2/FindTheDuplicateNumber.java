"
using fast ans slow pointer  as there is duplicate present that means there exists cycle .

![image](https://assets.leetcode.com/users/images/cdca9bd2-403f-42c1-be41-20f515d0b3f9_1648559053.9964356.png)

"

class Solution {
    public int findDuplicate(int[] nums) {
        // without using extra space or modify data
        
        // find cycle
        int slow =  nums[0];
        int fast = nums[0];
        
        while(true){
            slow =  nums[slow];
            fast =  nums[nums[fast]];            
            
            if(slow==fast) break;
        }
        // reset slow
        slow =  nums[0];
        while(slow!=fast){
            slow =  nums[slow];
            fast =  nums[fast];
        }
        return  slow;
        
    }
}