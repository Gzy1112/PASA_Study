import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Gzy1112
 * 题目：有效的括号
 * 方法一：利用栈
 * ( / [ / { 推入栈
 * ) / ] / } 若栈为空，或栈顶元素无法匹配括号，则出错。若栈顶元素匹配括号，出栈栈顶元素。
 * 最后查看栈是否为空。
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        //字符串长度
        int length = s.length();
        if(length % 2 != 0){
            //长度为奇数
            return false;
        }
        Map<Character,Character> map = new HashMap<>(4){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        //新建栈
        Deque<Character> stack = new LinkedList<>();

        for(int i=0;i<length;i++){
            if(map.containsKey(s.charAt(i))){
                //栈为空或不匹配，则返回false
                if(stack.isEmpty() || !stack.peek().equals(map.get(s.charAt(i)))){
                    return false;
                }
                //能匹配，则弹出栈顶元素
                else{
                    stack.pop();
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        //最后栈为空即说明正确
        return stack.isEmpty();
    }
}
