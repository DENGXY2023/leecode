package qusetions;

public class Q24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev= new ListNode();

        prev = head.next;
        head.next = head.next.next;
        prev.next = head;
        prev.next.next = swapPairs(head.next);
        return prev;
    }
    public ListNode swapPairs_2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev= new ListNode();
        prev = head.next;
        head.next = swapPairs(prev.next);
        prev.next = head;
        return prev;
    }

    public static void main(String[] args) {
        Q24_SwapPairs q24 = new Q24_SwapPairs();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4))));
        ListNode r = q24.swapPairs(head);
    }
}
