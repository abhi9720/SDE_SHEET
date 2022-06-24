class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] =  version1.split("\\.");
        String v2[] =  version2.split("\\.");
        
        int l1 =  v1.length , l2 =  v2.length;
        int l =  Math.min(l1,l2);
        int i=0;
        
        
        
        for(;i<l;i++){
            int val1 =  Integer.parseInt(v1[i]);
            int val2 =  Integer.parseInt(v2[i]);
            
            if(val1 < val2) return -1;
            else if(val1 > val2) return 1;
        }
        int L =  Math.max(l1,l2);
        for(;i<l1;i++){
            if(Integer.parseInt(v1[i]) !=0 ) return 1;
        }
        
        for(;i<l2;i++){
            if(Integer.parseInt(v2[i]) !=0 ) return -1;
        }
        
        return 0;
    }
}