/**
 * @author Gzy1112
 *  题目：完全平方数
 *  动态规划
 *  f(i) = 1 + min(j=1----sqrt(i))f(i-j*j)
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        for(int i=1 ; i<=n ; i++){
            int minValue = Integer.MAX_VALUE;
            for(int j=1 ; j*j<=i ; j++){
                minValue = Math.min(minValue,ans[i-j*j]);
            }
            ans[i] = minValue + 1;
        }
        return ans[n];
    }
}
