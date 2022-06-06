class GfG
{
    Node flatten(Node root)
    {
        Node head = null;
        Node itr =   root;
        while(itr!=null){
            head =  mergerTwoSortedList(head,itr);
            itr =  itr.next;
        }
        return head;
    }
    
    Node mergerTwoSortedList(Node l1 , Node l2){
        
        Node head =  null,tail=null;
        Node dummy  = new Node(-1);
        head = tail  =  dummy;
        
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l1.data <= l2.data)){
                tail.bottom =  l1;
                tail =  l1;
                l1 =  l1.bottom;
            }
            else{
                tail.bottom =  l2;
                tail =  l2;
                l2 =  l2.bottom;
            }
        }                
        return head.bottom;
    }       
}


