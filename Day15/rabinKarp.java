class Solution {
    public int strStr(String source, String target) {
        int M = source.length();
        int N = target.length();
        
        if (M < N)
            return -1;
        
        
        long hSource = 0;// hash of source
        long hTarget = 0;// hash of target
        long base = 31; // base
        long mod = 1000000000000000003L; // hash table size , to handle very large number 
        
        
        // preCompute =  base^(N-1) need to remove out of window character 
        // as we need to remove out of window digit we multiply it wit char*base^(N-1)
        long preCompute = 1;        
        for (int i = 0; i < N - 1; i++) {
            preCompute = (preCompute * base) % mod; 
        }
        
        
        for(int i=0;i<N;i++){
            hSource = ( hSource*base + source.charAt(i))%mod;
            hTarget = ( hTarget*base + target.charAt(i) )%mod;            
        }
        if(hTarget==hSource) return 0;
        
        for(int j=1;j<=M-N;j++){

            // this is where we are rolling our hash value to calculate next hashvlaue
            // removed out of window character
            hSource =  (hSource - source.charAt(j-1)*preCompute)%mod;
            
            // add new character of this window 
            hSource =  (hSource*base + source.charAt(j+N-1))%mod;
            
            if(hSource==hTarget){
                if(source.substring(j,j+N).equals(target) ){
                    return j;
                }                
            }                
        }
        return -1;
    }
}

