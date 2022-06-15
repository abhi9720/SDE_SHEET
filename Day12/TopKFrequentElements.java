/*
we want top k occuring element by freq 
to store freq we use hashmap
then maintain pq of frequency 
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> fmap =  new HashMap<>();
        for(int ele : nums){
            fmap.put(ele  , fmap.getOrDefault(ele,0)+1 );
        }
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->{
            return fmap.get(a) - fmap.get(b);
        });
        
        for(int key : fmap.keySet() ){
            pq.add(key);
            if(pq.size()  >k){
                pq.poll();
            }
        }
        int i =0;
        int ans[] =  new int[k];
        while(pq.size()>0 ){
            ans[i++] =  pq.remove(); 
        }
        return ans;
    }
}


