package qusetions;

public class Q21_MergeTwoLists {
    // 迭代
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode();
        ListNode start = prev;
        start.next = prev;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                prev.next = list1;
                list1 = list1.next;
            }
            else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1==null?list2:list1;
        return start.next;
    }
    // 迭代
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next = mergeTwoLists_2(list1.next,list2);
            return list1;
        }
        list2.next = mergeTwoLists_2(list1,list2.next);
        return list2;
    }

    public static void main(String[] args) {
        Q21_MergeTwoLists q21 = new Q21_MergeTwoLists();
        ListNode l1 = new ListNode(1,new ListNode(2));
        ListNode l2 = new ListNode(2,new ListNode(3));
        ListNode ln = q21.mergeTwoLists_2(l1,l2);
        System.out.println(ln);
    }
}
