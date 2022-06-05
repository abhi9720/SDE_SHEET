"
Insert all elements in HashMap and for an element explore all its neighbor 
if found increment count and remove from hashmap and move to next heighbour
"
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =  new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        int maxlen = 0;
        for(int ele : nums){            
            int right =  ele+1;
            while(set.contains(right) ){set.remove(right); right+=1;}
            int len =  right-ele;
            maxlen =  Math.max(maxlen,len);            
        }
        return maxlen;
                    
    }
}