
/*
    -> To avoid duplicacy 
    eg. 1,2,2
    when idx =  1  and we are running loop for it 
    we want first occured 2 add after 1 but 2nd times occured 2 should not be added 
    to avoid this, -> we keept one check 
    if(i> idx and nums[i]==nums[i-1] ) continue;
    i > idx  ensures one time run
    and if one time runnned then it start checking condition nums[i] == nums[i-1] or not 
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();
        subsetsWithDupHelper(nums,ans,new ArrayList<Integer>() , 0);
        return ans;
    }
    private void subsetsWithDupHelper(int []nums,List<List<Integer>> ans,ArrayList<Integer> curr , int idx){
        int n =  nums.length;
        
        ans.add(new ArrayList(curr));
        for(int i =  idx;i<n;i++){
            if(i>idx && nums[i] == nums[i-1] ) continue;
            
            curr.add(nums[i] );
            subsetsWithDupHelper(nums,ans,curr,i+1);
            curr.remove(curr.size()-1  );
            
        }        
    }
}