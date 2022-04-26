/**
 * @author Gzy1112
 * 题目：单词拆分
 * dp[i] = dp[j] + check(j,i)
 * dp[i] 代表s[0...i-1]能否成功分词
 * j相当于是s[0....i-1]中的断点
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordList = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1 ; i<=s.length() ; i++){
            for(int j=0 ; j<i ; j++){
                if(dp[j] && wordList.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
