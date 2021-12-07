package qusetions;

public class Q206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode();
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
