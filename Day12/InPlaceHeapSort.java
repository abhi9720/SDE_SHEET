public class Solution {

    private static void insertIntoVirtualHeap(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        while(childIndex > 0){
            if(arr[childIndex] < arr[parentIndex] ){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }else{
                return;
            }
        }

    }

    private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {

        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;

        // atleast left child should exists 
        while( 2 * index + 1 < heapSize){

            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            int minIndex = leftChildIndex;
            
            if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[leftChildIndex]){
                minIndex = rightChildIndex;
            }

            if(arr[minIndex] < arr[index]){
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex]  = temp1;
            }
            else break;
            index =  minIndex;

        }
        return temp;
    }

    public static void inplaceHeapSort(int input[]) {
        for(int i = 0; i < input.length; i++){
            // here we are maitaiing min priorityQueue
            // using same array to make it min heap
            insertIntoVirtualHeap(input,i);
        }
        for(int i = 0; i < input.length; i++){
            input[input.length - 1 - i] = removeMinFromVirtualHeap(input, input.length - i);
        }
    }
}