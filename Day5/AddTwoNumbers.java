class Solution {

   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                
        int s=0,c=0;  
        
        ListNode head = null,tail=null;
        
       
        
        while(l1!=null || l2!=null || c!=0){
            s =  (l1==null?0:l1.val) + (l2==null?0:l2.val) +c;
            l1 =  l1==null?null:l1.next;
            l2 =  l2==null?null:l2.next;
            c  = s/10;
            s%=10;
            ListNode sumNode =  new ListNode(s);            
            if(head ==null){
                head=  tail =  sumNode;
            }
            else{
                tail.next =  sumNode;
                tail =  sumNode;
            }
            // sumNode.next =  head;
            // head = sumNode;            
        }
        
        return head;        
    }

   private int len(ListNode head) {
	   int len = 0;
	   while(head!=null){
		   head =  head.next;
		   len+=1;
	   }
	   return len;
   }
   
}
