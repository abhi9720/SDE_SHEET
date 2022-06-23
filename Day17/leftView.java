// Approac 1: Using bfs , -  level order traversal 
// 0th index node of each level is part of left view        

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      Queue<Node> q =  new ArrayDeque<>();
      ArrayList<Integer> li =  new ArrayList<>();
      if(root==null) return li;
      q.offer(root);
      while(!q.isEmpty() ){
          int size =  q.size();
          
          for(int i=0;i<size ;i++ ){
              Node peek  =  q.poll();
              if(i==0) li.add(peek.data);
              if(peek.left!=null){
                  q.offer(peek.left);
              }
              if(peek.right!=null){
                  q.offer(peek.right);
              }
          }
      }
      return li;
    }
}

// Approach 2 using dfs

// as we first time reach new depth , add its in list 
// as path size will be increased for other node at same depth
// they cannot be added them

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> li =  new ArrayList<>();
        leftViewDFS(root,0,li);
        return li;
      // Your code here
    }
    
    private void leftViewDFS(Node root, int depth , ArrayList<Integer> path){
        if(root==null) return ;
        
        // as we first time reach new depth , add its in list 
        // as path size will be increased for other node at same depth
        // they cannot be added them
        if(depth == path.size() ){
            path.add(root.data);
        }
        
        leftViewDFS(root.left,depth+1,path);
        leftViewDFS(root.right,depth+1,path);
    }
    
}