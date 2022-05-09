/**
 * @author Gzy1112
 * 无重复字符的最长子串
 * 方法：哈希集合（不能出现重复字符）
 * 左右两个指针限定子串范围
 */
import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        //哈希集合，记录字符是否存在
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        //右指针
        int rk = -1;
        //记录无重复字符串长度
        int ans = 0;
        for(int i=0;i<n;i++){
            //左指针向后移动一位，则将原先的字符删除
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            //右指针不断右移，无重复则加入哈希集合
            while(rk+1<n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
