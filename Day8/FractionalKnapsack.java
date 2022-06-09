Here we have greed of picking the weight which give maximum profit , and
we are also allowed to pick fractional weight 
, so even if total weight is greater than our bag capacity and it has higher
wt. per unit value , still we are able to pick it 

thats why we sort our pair class array by density (so we pick maximum weight ) till our
bag not filled completely 
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
 
class pair{
    int i;
    double density;
    public pair(int idx , double density){
        this.i =  idx;
        this.density =  density;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // as partial wait picking is allowed 
        pair data[] =  new pair[n];
        for(int i=0;i<n;i++){
            double density =  (arr[i].value)*(1.0) / arr[i].weight;
            data[i] =  new pair(i,density);
        }
        Arrays.sort(data,(o1,o2)->{
            if(o1.density>o2.density) return -1;
            else return 1;
        } );
        double profit = 0;
        for(int i=0;i<n && W>0;i++){
            int w = ( W > arr[data[i].i].weight  ) ?arr[data[i].i].weight : W;
            W-=w;
            profit+= data[i].density*w;
            
        }
        
        return profit;
        
    }
}









