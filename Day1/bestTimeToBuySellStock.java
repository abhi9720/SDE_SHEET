"
Keep price as minimum as possible keep updating it  and keep track of the global minimum
"


class Solution {
    public int maxProfit(int[] prices) {
        
        // buy at as lower as possible 
        int maxProfit = 0;
        int min = prices[0];
        for(int ele : prices){
            if(ele < min){
                min =  ele;
            }
            else {
                maxProfit =  Math.max(maxProfit , ele - min);
            }
        }
        return maxProfit;
    }
}