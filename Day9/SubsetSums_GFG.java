
//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> sums =  new ArrayList<>();
        genrateAllSubset(arr,sums,0,0);
        return sums;
    }
    
   void genrateAllSubset(ArrayList<Integer> arr ,ArrayList<Integer> sums,int idx ,int currsum ){
            if(idx==arr.size() ){
                sums.add(currsum);
                return ;
            }
            genrateAllSubset(arr,sums,idx+1,currsum+arr.get(idx) );
            genrateAllSubset(arr,sums,idx+1,currsum);
    }
}