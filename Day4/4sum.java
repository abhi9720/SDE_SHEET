"
Ksum technique

"

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums,target,4,0);
      }
    
    public List<List<Integer>> ksum(int nums[],int target,int k,int index){
      List<List<Integer>> res  =  new ArrayList<>();
    if( index >= nums.length  ) return res;
        if(k ==2){ // if k is two then simply return two pair sum 
            
            List<List<Integer>> ans =  twoSum(nums,target,index,nums.length-1);            
            
            return ans;
        }
        else{ // simply reduce dimension ,  make new call for k-1 
            for(int i  =  index  ; i<nums.length-k+1;i++){
                List<List<Integer>> ans =  ksum(nums,target-nums[i],k-1,i+1);
               if(ans!=null){
                     for(List<Integer> l : ans){
                     l.add(0,nums[i]);                     
                 }
               }
                res.addAll(ans);
                
                // skip duplicates 
                while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
            }
            
            
            
        }
        
        
        return res ;
        
    }
    private List<List<Integer>> twoSum(int nums[],int target,int i,int j){
        List<List<Integer>>  res =  new ArrayList<>();
        
        while(i<j){
            
            int sum  =  nums[i]+nums[j];
            if(sum<target){
                i++;
            }
            else if(sum>target){
                j--;
                
            }
            else{
                ArrayList<Integer> l =  new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                res.add(l);
            while(i<j && nums[i]==nums[i+1]) i++;
            while(i<j && nums[j]==nums[i-1]) j--; 
                
                i++;
                j--;
                // avoding duplicates 
                                              
            }
             
            
        }
        
        return res;
        
        
    }
}
        
        
    
    
    
