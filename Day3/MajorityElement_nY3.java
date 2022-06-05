"
Here keep two variable ele1, ele2 and two count 

"
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans =  new ArrayList<>();
        
        int ele1 = Integer.MIN_VALUE,ele2 = Integer.MIN_VALUE;
        int count1=0,count2=0;
        int n =  nums.length;
        for(int ele : nums){
            if(ele==ele1)count1++;
            else if(ele==ele2) count2++;
            else if(count1==0){
                ele1 =  ele;     
                count1=1;
            }
            else if(count2==0){
                ele2  =  ele;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = count2=0;
        for(int ele : nums){
            if(ele==ele1) count1++;
            if(ele==ele2) count2++;
        }
        
        
        if(count1>n/3) ans.add(ele1);
        if(count2>n/3) ans.add(ele2);
        return ans;
        
    }
}