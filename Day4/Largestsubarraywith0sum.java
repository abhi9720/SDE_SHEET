"
Keep a global maximum of length, as a subarray of 0 sum find
Use HashMap -  to update Sum
"
class GfG
{
    int maxLen(int arr[], int n)
    {
        // sum,index
        HashMap<Integer,Integer> map =  new HashMap<>();
        map.put(0,-1);
        int sum = 0,maxlen=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum) ){
                int len =  i  - map.get(sum);
                maxlen =  Math.max(maxlen,len);
            }
            else{
                map.put(sum,i);
            }
        }
        
        return maxlen;
    }
}