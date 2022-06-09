"
Just Opposite to merge intervals, find the total unmerged interval

sort by end time, next_start_time <= curr_end_time , meeting cannot be happend
if next_start_time > curr_end_time , then room is free meeting can be done 

"

class Solution 
{
    
    public static int maxMeetings(int start[], int end[], int n){
        int pair[][] = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i] = new int[]{start[i] , end[i] };
        }
        
        Arrays.sort(pair , (o1,o2)->o1[1] - o2[1]);
        int count = 1;
        int s  =  pair[0][0];
        int e  =  pair[0][1];
        
        int i=1;
        while(i<n){
            if(pair[i][0] > e  ){
                count+=1;
                s =  pair[i][0];
                e =  pair[i][1];
            }
            i+=1;
        }
        return count;
    }
}
