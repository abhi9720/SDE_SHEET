"
1. DFS with memoization 
2. Bottom up Dp
3.permutation formula (d+r)!/d!*r! , d =  down movement, r =  right movement

"

//  using dp , by bottom-up approach 

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]  =  new int[m][n];
        Arrays.fill(dp[m-1],1);
        for(int i=0;i<m;i++){
            dp[i][n-1]  = 1;
        }
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] =  dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}



// By Mathmatics -  using permutations


public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}
