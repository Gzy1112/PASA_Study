/**
 * @author Gzy1112
 * 题目：相交链表
 * 哈希集合
 */
import java.util.HashSet;
import java.util.Set;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        if(headA == null || headB == null){
            return null;
        }
        while(headA!=null){
            nodeSet.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(nodeSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}