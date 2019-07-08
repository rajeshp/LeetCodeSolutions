public class RemoveNthNodeFromEndOfList {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        int i=0;
        while(i < n && p != null){
            p = p.next;
            i++;
        }

        if(p == null){
            return q.next;
        }

        while(p.next != null){
            p = p.next;
            q = q.next;
        }

        //if(q == head)
        //  return q.next;

        if(q.next != null)
            q.next = q.next.next;
        else
            return null;

        return head;
    }
}
