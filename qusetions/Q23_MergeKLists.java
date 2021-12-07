package qusetions;

import java.util.List;
import java.util.PriorityQueue;

public class Q23_MergeKLists {
    // 两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(ListNode ln:lists){
            res = mergeTwoLists(res, ln);
        }
        return res;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode();
        ListNode curr = prev;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1==null?list2:list1;
        return prev.next;
    }
    // 优先队列
    public ListNode mergeKLists_2(ListNode[] lists) {
        PriorityQueue<ListNode> quene = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        ListNode head = new ListNode();
        ListNode tail = head;
        for(ListNode ln:lists){
            if(ln!=null){
                quene.offer(ln);
            }
        }
        while (!quene.isEmpty()){
            ListNode q = quene.poll();
            tail.next = q;
            if(q.next!=null){
                quene.offer(q.next);
            }
            tail = tail.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Q23_MergeKLists q23 = new Q23_MergeKLists();
        ListNode l1 = new ListNode(3,new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode[] l = new ListNode[]{l1, l2, l3};
        ListNode res = q23.mergeKLists_2(l);
        System.out.println();
    }
}
