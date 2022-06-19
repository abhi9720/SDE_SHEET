 class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix =  strs[0];
        int n =  strs.length;
        for(int i=1;i<n;i++){
            // compare prefix and strs[i] from start
            int j=0;
            String str =  strs[i];
            while(j<Math.min(prefix.length() , str.length() ) ){
                if(prefix.charAt(j) != str.charAt(j) ) break;
                j++;
            }
            prefix = prefix.substring(0,j);                        
            if(prefix.length()==0 ) break;
        }
        return prefix;
    }
}
// Approach 2 : runtime better 
class Solution {
    public String longestCommonPrefix(String[] strs) {

        return optimise_code(strs);
    }
    private String optimise_code(String strs[]){
        if(strs==null || strs.length==0) return "";
        String prefix=   strs[0];
        for(int i=1;i<strs.length;i++){
            // if match found from staring the indexof function return 0
            // otherwise return negative value -1
            while(strs[i].indexOf(prefix)!=0)    {                
                prefix  =  prefix.substring(0,prefix.length()-1);
            }            
            if(prefix.length()==0) break;
        }
        return prefix;                 
    }
    
    
}








