"
If a trains come, station master get information for coming train,  
he start updating sheet, So any train whose department time smaller than 
our current time  has leaved the platform . So definitely 
 we need to decrease count of occupied trains
"


class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        int pair[][] =  new int[n][2];
        int count = 1, maxCount = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=1;
        while(j<n){
            while( i<j && dep[i] < arr[j] ){
                count-=1;
                
                
                i+=1;
            }
            count+=1;
            maxCount =  Math.max(maxCount,count);
            j+=1;
        }
        return maxCount;
    }
    
}

