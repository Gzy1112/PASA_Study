/**
 * @author Gzy1112
 * 题目：反转链表
 * 方法一：迭代
 * 方法二：递归
 *
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
