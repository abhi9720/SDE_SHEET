"
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
"

class Solution {
    public int romanToInt(String s) {
        char prev = ' ';
        int num = 0;
        for(int i=0;i<s.length() ;i++ ){
            char curr =  s.charAt(i);
            if(value(prev) >= value(curr) ){
                num+=value(curr);
            }
            else{
                num+= ( value(curr) - 2*value(prev) );
            }
            prev =  curr;
        }
        return num;
        
    }
    int value(char ch){
        if(ch=='I') return 1;
        else if(ch=='V') return 5;
        else if(ch=='X') return 10;
        else if(ch=='L') return 50;
        else if(ch=='C') return 100;
        else if(ch=='D') return 500;
        else if(ch=='M') return 1000;
        else return Integer.MAX_VALUE;
    }
}