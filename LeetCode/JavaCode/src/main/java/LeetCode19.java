//import java.util.Deque;
//import java.util.LinkedList;

/**
 * @author Gzy1112
 * 题目：删除链表的倒数第N个节点
 * 方法一：栈（先进后出）
 * 方法二：计算链表长度，计算正数删除的节点是多少个
 * 方法一、方法二：寻找到要删除节点的前一个节点
 */
public class LeetCode19 {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//         //哑节点 它的next指针指向链表的头节点
//         //本题删除节点y,需要知道y的前驱节点x
//         //头结点不存在前驱节点，如果不添加哑节点，需要进行特殊判断
//         ListNode dummy = new ListNode(0,head);
//         //计算链表长度
//         int length = 0;
//         while(head != null){
//             length++;
//             head = head.next;
//         }
//         ListNode cur = dummy;
//         for(int i=1;i<length-n+1;i++){
//             cur = cur.next;
//         }
//         cur.next = cur.next.next;
//         return dummy.next;
//     }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        //哑节点
//        ListNode dummy = new ListNode(0,head);
//        //Deque双端队列
//        Deque<ListNode> stack = new LinkedList<>();
//        ListNode cur = dummy;
//        //将每个列表元素放入栈中
//        while(cur != null){
//            stack.push(cur);
//            cur = cur.next;
//        }
//        //从栈中pop出n个元素
//        for(int i=0;i<n;i++){
//            stack.pop();
//        }
//        //寻找到删掉元素的前一个元素
//        //栈顶部元素（删掉元素的前一个元素）
//        ListNode prev = stack.peek();
//        prev.next = prev.next.next;
//        return dummy.next;
//    }
}
