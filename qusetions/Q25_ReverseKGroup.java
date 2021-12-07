package qusetions;

public class Q25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevFast = new ListNode();
        ListNode prev = prevFast;
        while(head!=null){
            ListNode fast = null;
            ListNode slow = head;
            Boolean flag = false;
            for(int i=0;i<k;i++) {
                if (slow == null) {
                    flag = true;
                    break;
                }
                slow=slow.next;
            }
            if(flag){
                prevFast.next = head;
                break;
            }
            for(int i=0;i<k;i++){
                ListNode next = head.next;
                head.next = fast;
                fast=head;
                head = next;
            }
            prevFast.next=fast;
            while (prevFast.next!=null){
                prevFast=prevFast.next;
            }
        }

        return prev.next;
    }
    public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public ListNode[] reverseList(ListNode head,ListNode tail) {
        ListNode prev = null;
        ListNode p = head;
        while(prev!=tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{prev, head};
    }
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7)))))));
        Q25_ReverseKGroup q25 = new Q25_ReverseKGroup();
        ListNode res = q25.reverseKGroup_2(head, 3);
        System.out.println(res);
    }
}
