// Appraoch using min-priority Queue
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            if (pq.size() < k) {
                pq.offer(ele);
            } else if (pq.peek() < ele) {
                pq.poll();
                pq.offer(ele);
            }
        }
        return pq.peek();
    }
}


//  Using quick selection with random index as pivot to avoid burst case run time 


class Solution {
    
  
    
    public int findKthLargest(int[] nums, int k) {
        k =  nums.length-k;
        int left =  0, right=nums.length-1;
        while(left<=right){
            int pidx =  new Random().nextInt(right-left+1)+left;
            int idx =  partitionArray(nums,left,right,pidx);
            
            if(idx==k){
                return nums[idx];
            }else if(idx+1 > k){
                right =  idx-1;
            }else{
                left =  idx+1;
            }          
            
        }
        
        return -1;
    }
    
    int partitionArray(int nums[] , int left, int right,int pidx){
        int pele =  nums[pidx];    
        // take this element to last
        swap(nums,pidx , right);                        
        pidx = left;
        for(int i =  left ; i<right;i++){
            if( nums[i] <= pele  ){
                swap(nums, pidx , i);
                pidx++;                    
            }
        }
        // partition :   <=  |   > | pivot
        // take partition element of its correct positin
        swap(nums,pidx , right);                        
        return pidx;
    }
    private void swap(int nums[], int a ,int b){
        int t =  nums[a];
        nums[a] =  nums[b];
        nums[b] = t;
    }
}



 