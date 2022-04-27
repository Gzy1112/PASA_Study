import java.util.HashSet;
import java.util.Set;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> cycleList = new HashSet<ListNode>();
        ListNode p = head;
        while(p!=null){
            if(!cycleList.add(p)){
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
