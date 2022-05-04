/**
 * @author Gzy1112
 *  题目：字符串解码
 */
import java.util.Stack;

public class LeetCode394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            //把所有的字母push进去，除了]
            if(c!=']'){
                stack.push(c);
            }
            else{
                //step1:取出[]内字符串
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    //插到索引位置为0的位置，原本索引位置及后面的字符向后顺延
                    sb.insert(0,stack.pop());
                }
                //[]内字符串
                String sub = sb.toString();
                //去除[
                stack.pop();

                //step2:获取倍数数字
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                int count = Integer.valueOf(sb.toString());

                //step3: 根据倍数把数字push回去
                while(count>0){
                    for(char ch : sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        //把栈中所有的字母取出来
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}
