"
Approach 1: using m*n extra space, to know the intial zeros of matrix and mark corressponding rows and cols in orginal matrix 

Approach 2: instead of using m*n extra space , use two boolean array and mark 
rows and cols into booleans array then itertate corresponding rows and cols and mark it 0

Approach 3: Instead of creating new boolean array , use first row and first col to mark 


"
class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rows[] = new boolean[200];
        boolean cols[] = new boolean[200];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]==0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (rows[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (cols[j]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
