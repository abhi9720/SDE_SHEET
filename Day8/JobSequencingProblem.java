"
Sort the jobs according to profit -> as we want  to have maximum profit , but to have maximum profit , perform jobs on their lastDay. if in case job last day is occupied , try to alot (1 to dealline-1  ) if any slot free 

Overall, if two date have deadline same then consider the jobs with high profit 
let {job_id,deadline,profit} -> {1,4,30},{2,3,20},{3,4,60}
sorted => {3,4,60},{1,4,30},{2,3,20}

as day 4 will be occupied by job_id =  3, then day will be alloted to job_id=1, as it has profit 30 , higher than the job with job_id=2 , then day2 will be alloted to job_id=2
"

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
      int[] JobScheduling(Job arr[], int n){
        int count = 0, profit = 0;
        Arrays.sort(arr,(o1,o2)-> o2.profit - o1.profit );
        int time[] =  new int[101];
        Arrays.fill(time,-1);
        for(int i=0;i<n;i++){
            int t =  arr[i].deadline;
            while(t>0){
                if(time[t]==-1 ){
                    time[t] =  arr[i].id;
                    count++;
                    profit+=arr[i].profit;
                    break;
                }
                t-=1;
            }
        }
        return new int[]{count, profit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/