"
1. duplicate node 
2. now setup pointer random pointers
3. now reset connections back as orginal
"
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node temp =  head;
        // duplicate node 
        while(temp!=null){
            Node nextNode =  temp.next;
            Node newNode =  new Node(temp.val);
            temp.next =  newNode;
            newNode.next =  nextNode;
            temp =  nextNode;                
        }
        
        // now setup pointer 
        temp =  head;
        while(temp!=null){
            Node clone =  temp.next;
            if(temp.random!=null){
                clone.random = temp.random.next;
            } 
            temp =  clone.next;            
        }
        
        // now reset connections back as orginal 
        temp =  head;
        Node newHead =  temp.next, tail = temp.next ;
        while(temp!=null && tail.next!=null){            
            temp.next =  tail.next;
            tail.next =  temp.next.next;
            tail =  tail.next;         
            temp =  temp.next;
        }
        temp.next = null;
        return newHead;
    }
}