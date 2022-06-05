class Solution {
    public ListNode middleNode(ListNode head) {
        return approach2(head);
    }
    
    
    private ListNode approach1(ListNode head ){ 
        /* Time = O(n)  space =  o(1)*/
        int len=0;        
        for(ListNode temp=head;temp!=null; temp =  temp.next) len++;
        
        ListNode mid = head; 
        for(int i=0;i<len/2;i++){ 
            mid =  mid.next;
        }
        return mid;
    }
        
        
    private ListNode approach2(ListNode  head){
        /* Time = O(n)  space =  o(1) but runtime better as n/2 length 
        loop will run instead of n  
        */
        ListNode rabbit = head, tortoise  =  head;
        // we have to return second mid in even length list
        while(rabbit!=null && rabbit.next!=null){ 
            rabbit =  rabbit.next.next;// two step
            tortoise =  tortoise.next; // one step 
        }
        return tortoise;
    }
}