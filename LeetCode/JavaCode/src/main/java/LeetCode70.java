/**
 * @author Gzy1112
 *题目：爬楼梯
 * 动态规划
 * f[i] = f[i-1] + f[i-2]
 *
 */
class LeetCode70 {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for(int i=2 ; i<=n ; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}