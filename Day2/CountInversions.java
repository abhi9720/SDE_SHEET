
class Solution
{
    
    static long inversionCount(long arr[], long N){
        return mergeSort(arr,0,arr.length-1);
        
    }
    private static long mergeSort(long arr[],int l, int r ){
        if(l<r){
            int mid =  (r-l)/2+l;
            long c1 = mergeSort(arr,l,mid);
            long c2 = mergeSort(arr,mid+1,r);
            return c1+c2+merge(arr,l,mid,r);
        }
        else{
            return 0;
        }
    }
    private static long merge(long arr[],int l,int mid,int r){
        long count = 0;
        long buffer[] =  new long[r-l+1];
        int itr =  0;
        int p1 =  l, p2 =  mid+1;
        while(p1<=mid && p2<=r){
            if(arr[p1] <= arr[p2] ){
             buffer[itr++] =  arr[p1++];
            }
            else{
                count+= ( mid-p1+1  );
                buffer[itr++] =  arr[p2++];
            }
        }
        
        while(p1<=mid) buffer[itr++] =  arr[p1++];
        while(p2<=r) buffer[itr++] =  arr[p2++];
        
        for(int i = l;i<=r;i++){
            arr[i] = buffer[i-l];
        }
        // System.out.println(l+" "+r+" - count  : "+count);
        return count;
        
    }
    
}