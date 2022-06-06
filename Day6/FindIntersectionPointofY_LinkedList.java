"
 Move larger length list pointer , by the diff of length , to make them 
 equal from  Y point (if exists ) 
 "
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 =  len(headA) , len2 =  len(headB);
        
        while(len1>len2){
            headA =  headA.next;
            len1--;
        }
        while(len2>len1){
            headB =  headB.next;
            len2--;
        }
        
        
        while(headA!=null && headB!=null && headA!=headB){
            headA =  headA.next;
            headB =  headB.next;
        }
        if(headA == headB) return headA;
        else return null;
        
        
    }
    
    
    private int len(ListNode node){
        int count = 0;
        while(node!=null){
            count++;
            node =  node.next;
        }
        return count;
    }
}