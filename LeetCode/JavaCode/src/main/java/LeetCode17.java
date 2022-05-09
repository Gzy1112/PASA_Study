/**
 * @author Gzy1112
 * 题目：电话号码的字母组合
 * 方法一：回溯+哈希表
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        //.length() 获取字符串长度
        if(digits.length() == 0){
            return combinations;
        }
        //HashMap建立哈希表
        Map<Character,String> phoneMap = new HashMap<>(10){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        backtrack(combinations,phoneMap,0,digits,new StringBuffer());
        return combinations;
    }
    /**
     * 回溯
     */
    public void backtrack(List<String> combinations,Map<Character,String> phoneMap,int index,String digits,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }
        else{
            //获取数字对应的字符串
            String str = phoneMap.get(digits.charAt(index));
            //获取字符串的长度
            int strlen = str.length();
            for(int i = 0 ; i < strlen ; i++){
                combination.append(str.charAt(i));
                backtrack(combinations,phoneMap,index+1,digits,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
