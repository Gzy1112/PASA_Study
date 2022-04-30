import java.util.ArrayList;
import java.util.List;

/**
 * @author Gzy1112
 *  题目：回文链表
 *  将链表中的数值放入数组结构中
 *  双指针，一个从头开始，一个从尾开始，两两比较
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p.val);
            p = p.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while(front < back){
            if(!list.get(front).equals(list.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
