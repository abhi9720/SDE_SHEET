"
A trivial solution is to use two loops to go through 
all possible subarrays of array and count the number of 
subarrays having XOR of their elements as B.

Try using hashing to store the prefix xor and use it
 to count the number of subarrays having XOR of their element ass B.
"

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int curr_xor = 0,count = 0;
        HashMap<Integer,Integer> map =  new HashMap<>();
        map.put(0,1);
        for(int ele : A){
            curr_xor^=ele;
            if(map.containsKey(curr_xor^B) ){
                count+= map.get(curr_xor^B);
            }
            map.put(curr_xor,map.getOrDefault(curr_xor,0)+1);
        }
        return count;
    }
}
