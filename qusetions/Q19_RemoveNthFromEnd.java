package qusetions;

public class Q19_RemoveNthFromEnd {

     public ListNode removeNthFromEnd(ListNode head, int n) {
          int len = lenOfList(head);
          if(n==len){
               return head.next;
          }
          ListNode cur = head;
          ListNode pre = head;
          for(int i =0; i<len; i++){

               if(i==len-n){
                    pre.next=cur.next;
                    break;
               }
               pre =cur;
               cur = cur.next;
          }
          return head;
     }
     public ListNode removeNthFromEnd_2(ListNode head, int n) {
          int len = lenOfList(head);
          ListNode cur = head;
          if(n==len){
               return head.next;
          }
          for(int i =0; i<len-n-1; i++){
               cur = cur.next;
          }
          cur.next = cur.next.next;
          return head;
     }
     public int lenOfList(ListNode head){
          int len =0;
          while (head!=null){
               len++;
               head = head.next;
          }
          return len;
     }
     public void print(ListNode head){
          while (head!=null){
               System.out.println(head.val);
               head = head.next;
          }
     }

     public static void main(String[] args) {
          ListNode head = new ListNode();
          head.val =1;
          head.next = new ListNode();
          head.next.val =2;
          Q19_RemoveNthFromEnd q19 = new Q19_RemoveNthFromEnd();
          ListNode head2 = q19.removeNthFromEnd_2(head,2);
          q19.print(head2);

     }

}
