/**
 * @author Gzy1112
 * 题目：最小栈
 * 动态规划
 */
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {
    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;
        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(val,minStack.peek()));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
