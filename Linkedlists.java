Questions in this document:
1. Reverse LinkedList
2. Reverse LinkedList II
3. Reorder LinkedList


1. Reverse LinkedList
Solution 1: Iteratively

public Listnode reverseList(ListNode head){
    ListNode CurNode = head;
    ListNode PrevNode = null;
    
    while(CurNode!=null){
      ListNode NextNode = CurNode.next;
      CurNode.next = PrevNode;
      PrevNode = CurNode;
      
      CurNode = NextNode;
   }
   
   return PrevNode;  
}

Solution 2: Recursive

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode A = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        return A;

        
    }
