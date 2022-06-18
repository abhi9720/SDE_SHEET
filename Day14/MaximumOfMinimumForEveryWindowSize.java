/*

Here we are trying to find the size of window in which our current element is minimum 
then we take maximum of minimum of all window of size k 
and suppose some window size don't not exists then the element which is minimum in window of 
size k , can also be minimum in window of size k-1, k-2, and so on..

4 step 
------------------------
1: Find indexes of next smaller and previous smaller for every element.
For input {10, 20, 30, 50, 10, 70, 30}, array of indexes of next smaller is {7, 4, 4, 4, 7, 6, 7}. 
For input {10, 20, 30, 50, 10, 70, 30}, array of indexes of previous smaller is {-1, 0, 1, 2, -1, 4, 4}

2: This array indicates, the first element is minimum in the window of size 7, 
the second element is minimum in the window of size 3, and so on.
So window in which element is smaller is right[i]-left[i]-1


3. Create an auxiliary array ans[n+1] to store the result

for (int i=0; i < n; i++){
        // length of the interval
        int len = right[i] - left[i] - 1;

        
        ans[len] = max(ans[len], arr[i]);
        // maximum of minimum of all subarray is size len
}


4. for some entries left empty 

for (int i=n-1; i>=1; i--)
        ans[i] = max(ans[i], ans[i+1]);
        
Because if a element is minimum in window of size k from it
then that element in also minimum in window of size k-1 ,k-2,k-3



*/

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        
        int left[] =  new int[n];
        int right[] =  new int[n];
        Stack<Integer> prevSmaller =  new Stack<>();
        for(int i=0;i<n;i++){
            while(!prevSmaller.isEmpty() && arr[prevSmaller.peek()] >= arr[i] ){
                prevSmaller.pop();
            }
            if(prevSmaller.size()==0 ){
                left[i] =  -1;
            }
            else{
                left[i] = prevSmaller.peek();
            }
            prevSmaller.push(i);
        }
        
        Stack<Integer> nextSmaller =  new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!nextSmaller.isEmpty() && arr[nextSmaller.peek()] >= arr[i] ){
                nextSmaller.pop();
            }
            if(nextSmaller.size() ==0 ){
                right[i] = n;
            }
            else{
                right[i] =  nextSmaller.peek();
            }
            nextSmaller.push(i);
        }
        
        
        int ans[] =  new int[n+1];
        
         for (int i=0; i<n; i++)
        {
            // length of the interval
            int len = right[i] - left[i] - 1;
      
            // arr[i] is a possible answer for this length
            // 'len' interval, check if arr[i] is more than
            // max for 'len'
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // if some spot left empty to fill them 
        // if a elemene is minimum of size k , can also be minimum for the window size k 
          for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);
            
        int fans[] =  new int[n];
        System.arraycopy(ans,1,fans,0,n);
        return fans;
        
        
        
    }
}


or 

/*
or do 0 based indexing 
 int ans[] =  new int[n];
        
         for (int i=0; i<n; i++)
        {            
            int len = right[i] - left[i] - 1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }
        for (int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
 */