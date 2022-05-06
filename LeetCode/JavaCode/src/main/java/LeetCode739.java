/**
 * @author Gzy1112
 *  题目：每日温度
 *  单调栈
 *  https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
 *  查看单调栈实例进出
 */
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i=0 ; i<length ; i++){
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature>temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
