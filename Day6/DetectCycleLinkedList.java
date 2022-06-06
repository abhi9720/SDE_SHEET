
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 =  head, p2 =  head;
        while(p1!=null && p1.next!=null){
            p1 =  p1.next.next;
            p2 =  p2.next;
            if(p1==p2){
                return true;
            }
        }
        return false;        
    }
}   

// Entry point of cycle 

"
Assume the distance from head to the start of the loop is x1
the distance from the start of the loop to the point fast and slow meet is x2
the distance from the point fast and slow meet to the start of the loop is x3


fast = x1 + x2 + x3 + x2
slow = x1 + x2

Its just the relationship between the distance travelled by 
fast pointer and the distance travelled by the slow pointer.
x1 + x2 + x3 + x2 = 2 (x1 + x2)
"

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow =  head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }    
        return null;
    }
}
