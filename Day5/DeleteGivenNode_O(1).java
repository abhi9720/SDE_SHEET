class Solution {
    public void deleteNode(ListNode node) {
        ListNode next =  node.next;
        if(next==null) return;
        int t =  next.val;
        next.val=  node.val;
        node.val =  t;
        node.next =  next.next;
    }
}