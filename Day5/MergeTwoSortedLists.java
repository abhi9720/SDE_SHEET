 /**
 Inplace method without using extra space.
 Use same node 
  */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, tail = null;
        head =  tail = new ListNode(-1);
        
        while(list1!=null || list2!=null){
            if( list2==null ||  (list1!=null && ( list1.val < list2.val )) ){
                tail.next   =  list1;
                tail =  list1;
                list1 = list1.next;
            }
            else{
                tail.next   =  list2;
                tail =  list2;
                list2 = list2.next;
            }
        }
        ListNode sorted =  head.next;
        head.next =  null;
        return sorted;
    }
}