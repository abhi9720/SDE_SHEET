// Approach 1: Using Priority Queue
// Time Complexity 2*Nlogn
//  GIVE TLE on Leetcode 
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                ans[i - k] = pq.peek();
                pq.remove( nums[i-k] );
                pq.offer(nums[i] );
            }
        }
        ans[n-k] = pq.peek();
        return ans;
    }
}
/*---------------------------------------------------------------------------------*/
// Approach 2:
"Find next greater element for each element , 
1. If nge of that element lies in idx+k range then that 
   element will be maximum of the subarray starting from that element.
2. If nge of that element not in idx+k range that means that element is 
   maximum of the subarray starting from it 
"


class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<Integer>();
        int nge[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 0 && nums[stk.peek()] < nums[i]) {
                stk.pop();
            }
            if (stk.size() == 0) {
                nge[i] = n;
            } else {
                nge[i] = stk.peek();
            }
            stk.push(i);
        }

        int ans[] = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            /* either element in itself max or its nge lies on 
            the right to it , never be in left 
                [1,-1]
                1
                for -1 , j left behind i 
            */
            if (j < i) j = i;
            
            
/*
            we want to maximum of element in range i to i+k
            [5,3,6,7]
             k = 3
             for subarray from 3, nge =  6 but max is 7 
*/            
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans[i] = nums[j];
        }
        return ans;
    }
}

// we put j outside because we want to continue from where  we have left off

// if we every time start finding nge from current i index then it gives tle on leetcode 
//  int ans[] = new int[n-k+1];
//         for(int i=0;i<n-k+1;i++){
//             int idx = nge[i];
//             int j = i;
//             while( idx < i+k ){
//                 j =  idx;
//                 idx =  nge[idx];
//             }
            
//             ans[i] = nums[j];            
//         }
//         return ans;
        

/*---------------------------------------------------------------------------------*/

// Approach 3 
"Instead of keeping nge of element keep a dequeue to maintain k size window and
keep queue in decreasing order , so your front element is going to maximum 

1. It front element goes out of windoww simply remove it from front of  queue 

2. using double ended queue  beacuse , as getting higher element from last element in queue  
in same window  we remove it from end as it cannot be maximum of that window 
Time Complexity :  O(N) + O(N) ~=  O(N)
Space complexity : O(K) - As we removed out of window element 
"

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            
            // as we want to keep only window of size k from index i
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            /*
                1 3 -1 -3 5 3 6, k =  3
                like getting 3(index 2) , there is no sense to keep 1 (index 0) 
                as this never be going to max , as in same window bigger element joined 
                
                we just want to maintain a queue of element i-k+1 to i index
                storing in dec order from front to end 
                so front element is maximum of window 
            */
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }
}