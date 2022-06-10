class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean ndiag[] =  new boolean[2*n-1];
        boolean rdiag[] =  new boolean[2*n-1];
        boolean cols[] =  new boolean[n];
        char grid[][] = new char[n][n];
        for(char row[] : grid){
            Arrays.fill(row,'.');
        }
        List<List<String>> ans =  new ArrayList<>();
        dfs(ndiag,rdiag,cols,grid,0,ans);
        return ans;        
    }
    
    private void dfs(boolean ndiag[], boolean rdiag[], boolean cols[], char grid[][] , int row,                    List<List<String>> ans){
        int n  =  cols.length;
        
        if(n==row){
            ArrayList<String> soln =  new ArrayList<>();
            for(char ch[] : grid){
                soln.add(new String(ch) );
            }
            ans.add(soln);
            return ;
        }
        
        for(int col=0;col<n;col++){
            int nidx =  row+col , ridx =  (row-col)+n-1;            
            if(ndiag[nidx]==false &&  rdiag[ridx]==false && cols[col]==false ){
                ndiag[nidx] = rdiag[ridx] =  cols[col] =  true;
                grid[row][col] =  'Q';
                dfs(ndiag,rdiag,cols,grid,row+1,ans);
                grid[row][col] =  '.';
                ndiag[nidx] = rdiag[ridx] =  cols[col] =  false;;             
            }            
        }        
    }
}