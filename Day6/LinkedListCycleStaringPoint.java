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
