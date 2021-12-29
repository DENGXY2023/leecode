package qusetions;

import java.util.HashSet;
import java.util.Set;

public class Q141_HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head!=null){
            if(!nodeSet.isEmpty()&&nodeSet.contains(head)){
                return false;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return true;
    }
}
