/**
 * @author Gzy1112
 * 题目：环形链表
 * dp[i] = dp[j] + check(j,i)
 * dp[i] 代表s[0...i-1]能否成功分词
 * j相当于是s[0....i-1]中的断点
 */
import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> cycleList = new HashSet<>();
        while(head!=null){
            if(!cycleList.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
