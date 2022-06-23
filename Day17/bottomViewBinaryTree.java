// keep map of 
// x dis(horizontal distance) vs {depth , node val}

// if for same horizontal distanace , consider the node with more depth 
//if for same horizontal distanace  and same depth consider later node 
    //                    20
    //                 /    \
    //               8       22
    //             /   \     /   \
    //           5      3 4     25
    //                  /    \      
    //              10       14

    //  consider 4 over 3 as 4 come later 

class Solution
{
    
    int min = 0;
    public ArrayList <Integer> bottomView(Node root){
        min  = 0;
        // x dis - {depth , node val}
        HashMap<Integer,int[]> map =  new HashMap<>();
        dfs(root,0,0,map);
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int i=min;i<min+map.size();i++ ){
            ans.add(map.get(i)[1] );
        }
        return ans;
    }
    
    private void dfs(Node root,int dis,int depth,HashMap<Integer,int[]> map ){
        if(root==null) return ;
        
        min =  Math.min(dis,min);
        
        if(map.containsKey(dis) ){
            int prev[] =  map.get(dis);
            if(depth >=  prev[0]  ){
                prev[1] = root.data;
                prev[0]=  depth;
            }
        }
        else{
            map.put(dis , new int[]{depth,root.data});
        }
        
        dfs(root.left,dis-1,depth+1,map);
        dfs(root.right,dis+1,depth+1,map);
    }
    
    
}