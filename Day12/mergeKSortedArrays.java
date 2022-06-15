/**
    Main pair for each list 
    and priority of pair 
    and insert next available index of that list pair 
 */

import java.util.*;

class pair implements Comparable<pair>{
    int i,ele,idx;
    public pair(int i , int ele, int idx ){
        this.i = i;        
        this.ele=  ele;
        this.idx = idx;
    }
    public int compareTo(pair o){
        return this.ele  -  o.ele;
    }
}

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k){
        
		PriorityQueue<pair> pq =  new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            pq.offer(new pair(0,kArrays.get(i).get(0) ,i ) );
        }
        ArrayList<Integer> ans =  new ArrayList<>();
        while(pq.size() >0 ){
            pair peek =  pq.remove();
            int idx =  peek.idx;
            ans.add(peek.ele);
            // to insert it next element check wether it exists or not 
            if( peek.i+1 < kArrays.get(idx).size()    ){
                pq.add(new pair(peek.i+1,kArrays.get(idx).get(peek.i+1) ,idx ) );
            }            
        }
        return ans;
	}
}
