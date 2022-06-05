"
Two pointers HashSet keep track of unique char as duplicate found start 
removing Sliding Window

"
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,n=s.length();
        
        Set<Character> unique =  new HashSet<>();
        int len =  0, maxlen = 0;
        while(j<n){
            char ch =  s.charAt(j);
            if(!unique.contains(ch) ){
                unique.add(ch);
                len++;     
                j++;
            }
            else{
                while(unique.contains(ch)  ){                    
                    unique.remove(s.charAt(i) );
                    len--;
                    i++;                    
                }                                                
            }
            maxlen =  Math.max(len,maxlen);
        }
        return maxlen;        
    }
}