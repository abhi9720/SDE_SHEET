
// try brute force -  try each color on each node 
// before assigning color to vertex , check none of its neighbor have the same color 
// other wise assign new color to that vertex
// if v==n that means vertices are colored and we return  true 
// and now in recursive call result if true is coming don't backtrack simply return true

class solve {
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int vtcesColor[] =  new int[n];
        Arrays.fill(vtcesColor,-1);// -1 means no color 
        return dfs(graph,m,n,0,vtcesColor);
    }
    private  boolean dfs(boolean graph[][],int m, int n, int v,int vtcesColor[]){
        if(v==n){
            return true;
        }
        
        // for current vertex , give starting possible color 
        for(int c = 1;c<=m;c++){
            // if non of nbr have this color then only we can give this color 
            boolean cangive =  true;
            for(int i=0;i<n;i++){
                if(graph[v][i] ){
                 if(vtcesColor[i]==c) {
                     cangive =  false;
                     break;
                 }
                }
            }
            if(cangive){
                vtcesColor[v] = c;
                // make call to next node 
                if(dfs(graph,m,n,v+1,vtcesColor)) return true;
                vtcesColor[v] = -1;
            }
        }
        return false;
    }
}

