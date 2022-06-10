class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        permuteHelper(nums,ans,new LinkedList<Integer>() );
        return ans;
    }
    
    private void permuteHelper(int nums[], List<List<Integer>> ans,LinkedList<Integer> curr  ){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr) );
            return ;
        }
        // items choosing places
        // either 1 come , or 2 come , or 3 come 
        // then at next position , any of non-used element can come         
        for(int i=0;i<nums.length;i++){
            if(!curr.contains(nums[i] ) ){
                curr.addLast(nums[i] );
                permuteHelper(nums,ans,curr);
                curr.removeLast();
            }
        }    
    }
}