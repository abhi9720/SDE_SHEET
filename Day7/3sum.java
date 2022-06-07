class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n  =  nums.length;
        List<List<Integer>> ans =  new ArrayList<>();
        for(int k=0;k<n;k++){
            if(k>0 && nums[k]==nums[k-1])continue;
            int i =  k+1, j = n-1;
            while(i<j){
                int sum =  nums[i]+nums[j]+nums[k];
                if(sum<0){
                    i+=1;
                }
                else if(sum >0){
                    j-=1;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]) );
                    while(i<j && nums[i]==nums[i+1] ) i+=1;
                    while(i<j && nums[j]==nums[j-1] ) j-=1;
                    i+=1;
                    j-=1;
                }
            }            
        }
        
        return ans;
    }
}