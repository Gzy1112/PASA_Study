import java.util.ArrayList;
import java.util.List;
/**
 * @author Gzy1112
 * 题目：括号匹配
 * 递归：剩余左括号总数要小于等于右括号
 */

class LeetCode22 {
    /**
     * 在多个方法中使用，因此不在方法中定义，而选择定义为成员
     */
    public List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n<=0) {
            return ans;
        }
        getParentthesis("",n,n);
        return ans;
    }
    /**
     * left-当前剩余左括号数 right-当前剩余右括号数
     */
    private void getParentthesis(String str,int left,int right){
        //左右剩余括号数都为0，则结果加入数组
        if(left == 0 && right == 0){
            ans.add(str);
            return;
        }
        //剩余左括号等于剩余有括号，则下一个必须是左括号
        if(left == right){
            getParentthesis(str+"(",left-1,right);
        }
        //剩余左括号小于剩余右括号，则下一个可以是左括号，也可以是右括号
        else if(left < right){
            if(left > 0){
                getParentthesis(str+"(",left-1,right);
            }
            getParentthesis(str+")",left,right-1);
        }
    }
}
