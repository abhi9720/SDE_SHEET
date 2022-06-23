// just one thing change from bottom view 
// for same horizontal distance we are conidering the node with minimum depth 

class Solution
{
    
    int min = 0;
    public ArrayList <Integer> topView(Node root){
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
            if(depth <=  prev[0]  ){
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