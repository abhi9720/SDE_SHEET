// Approach 1 - Binary Search in row 
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // start from top-right corner then
        // left to it all element are smaller
        //  below in that column all element are greater

        int r = matrix.length;
        int c = matrix[0].length;

        int i = 0, j = c - 1;
        while (i >= 0 && j >= 0 && i < r && j < c) {
            if (matrix[i][j] >= target) { // move left
                int idx = binarySearch(matrix[i], target);

                if (idx == -1) return false; else return true;
            } else { // move down in column
                i = i + 1;
            }
        }
        return false;
    }

    private int binarySearch(int arr[], int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;

            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }
}



// Approach 2 - Binary Search in complete matrix

class Solution {

     public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int hi = (n * m) - 1;
        
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
