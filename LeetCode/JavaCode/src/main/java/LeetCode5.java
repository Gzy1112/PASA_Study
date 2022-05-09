/**
 * @author Gzy1112
 * 题目：最长回文子串
 * 方法一：动态规划
 * dp[i][j]表示子串[i...j]是否是回文子串
 * 两层循环，第一层循环子串长度，第二层循环左指针，右指针根据子串长度和左指针计算出来
 * 左指针i，右指针j
 * 判断charArray[i]和charArray[j]
 * 相等时，若j-i<3,dp[i][j]=true
 * 相等时，若j-i>=3,dp[i][j]=dp[i+1][j-1]
 * 不相等时，dp[i][j]=false
 *
 * 方法二：中心扩展
 * 一层循环，遍历字符串的每一个元素，每一个元素作为回文子串的中心
 * 因为回文子串的长度分为奇数和偶数长度
 * 回文子串的长度为奇数，回文中心只有一个字符
 * 回文子串的长度为偶数，回文中心有两个字符
 *
 * String类型 访问元素需要用 s.charAt(i)
 * Array类似 String.charArray() 访问元素只需要用索引Array[i]即可
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandString(s,i,i);
            int len2 = expandString(s,i,i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expandString(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left + 1 - 2;
    }
}
