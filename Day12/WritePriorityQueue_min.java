"
We have to maintain CBT  -  Compelete binary tree property and
                    HOP  -  Heap order Property.

 HOP -  it says
 MIN Heap => parent should be smaller than its childrens for all nodes
 MAX Heap => parent should be larger than its both chidrens for all nodes


This is min heap / min priority Queue implementation
for max  priorityQueue just change comparission sign 

"

import java.util.ArrayList;

class PriorityQueueException extends Exception {

}
public class PQ {

    private ArrayList<Integer> data;

    public PQ() {
        data = new ArrayList<Integer>();
    }

    boolean isEmpty(){
        return data.size() == 0;
    }

    int size(){
        return data.size();
    }

    int getMin() throws PriorityQueueException{
        if(isEmpty()){
            // Throw an exception
            throw new PriorityQueueException();
        }
        return data.get(0);
    }



    public void insert(int val) {
        data.add(val);
        upHeapify();
    }
    int removeMin() throws PriorityQueueException {

        if(isEmpty()) {
            throw new PriorityQueueException();

        }
        int min =  data.get(0);
        int lidx =  data.size() - 1;
        swap(0, lidx);
        data.remove(lidx);
        downHeapify();
        return min;

    }

    private void downHeapify() {
        int pidx =  0;
        while ( pidx * 2 + 1 < data.size() ) {
            int left =  pidx * 2 + 1, right =  pidx * 2 + 2;
            int swapidx =  left;
            if (right < data.size() && data.get(right) < data.get(left) ) {
                swapidx =  right;
            }
            if (data.get(swapidx ) < data.get(pidx) ) {
                swap(swapidx, pidx);
            }
            else {
                break;
            }
            pidx =  swapidx;
        }

    }
    private void upHeapify() {
        int cidx =  data.size() - 1;
        while (cidx > 0) {
            int pidx = (cidx - 1) / 2;
            if ( pidx >= 0 && data.get(pidx) > data.get(cidx) ) {
                swap(pidx, cidx);
            }
            else {
                break;
            }
            cidx =  pidx;
        }
    }

    private void swap(int i, int j) {
        int t =  data.get(i);
        data.set( i, data.get( j ) );
        data.set( j, t );
    }


}

