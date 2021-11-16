package qusetions;


public class Q2_AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1!=null||l2!=null){
            /* A ? B : C
             * A为真，则取B
             * 否则取C
             */
            int n1= l1 != null ? l1.val : 0;
            int n2= l2 != null ? l2.val : 0;
            int sum = n1+n2+carry;
            if(head==null){
                head = tail = new ListNode(sum % 10);
            }
            else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if (carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        Q2_AddTwoNum q2 = new Q2_AddTwoNum();
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode head = q2.addTwoNumbers(l1,l2);
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }

    }
}

