
class pairSum implements Comparable<pairSum>{
    int sum ;
    int i,j;
    public pairSum(int sum , int i  , int j){
        this.sum  =  sum;
        this.i =  i;
        this.j =  j;        
    }
    public int compareTo(pairSum o){
        return   o.sum-this.sum;
    }
    public String toString(){
        return sum+" @"+i+","+j;
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A);
        Collections.sort(B);
        
        PriorityQueue<pairSum> q =  new PriorityQueue();                        
        ArrayList<Integer> ans = new ArrayList<>();
        // using hashset to avoid insetion of same pairs which already inserted 
        // like {i,j} =  {16,17} -> {16,16},{15,17}
        // similar for {i,j} =  {15,18} -> {15,17} {14,18} here {15,7} will be repeated to avoid this we mark it 
        // used 
        HashSet<String> used =  new HashSet<>();
        int i =  A.size()-1;
        int j =  B.size()-1;
        
        q.offer(new pairSum(A.get(i)+B.get(j) , i,j ));
        used.add(i+","+j);
        
        while(C-->0 ){
            
            pairSum peek =  q.remove();
            
            ans.add(peek.sum);              
            
            i = peek.i;
            j =  peek.j;
            int ni =  i-1;
            int nj =  j - 1;
            // either i,nj or ni,j
            String code1 =  i+","+nj;
            String code2 =  ni+","+j;
            
           if(nj>=0 && i>=0 && !used.contains(code1) ){
               used.add(code1);
                q.offer(new pairSum(A.get(i) + B.get(nj),i,nj));
                
            }
            if(ni>=0 && j>=0 && !used.contains(code2) ){
                used.add(code2);
                q.offer(new pairSum(A.get(ni) + B.get(j),ni,j));
                
            }          
            
            
        }
        return ans;
    }
    
}
