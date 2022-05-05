/**
 * @author Gzy1112
 *  题目：目标和
 *  元素之和sum
 *  复数元素之和neg
 *  正数元素之和sum-neg
 *  (sum-neg)-neg = target
 *  neg = (sum-target)/2
 *  dp[i][j] 前i个数和为j的种类搭配数
 *  ps:第i个数在数组中是nums[i-1]
 *  dp[i][j] = dp[i-1][j] (j<nums[i-1])
 *  dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]] (j>nums[i-1])
 *  dp[n-1][target]
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }
        if(sum-target < 0 || (sum-target)%2 != 0){
            return 0;
        }
        //计算目标值
        int neg = (sum - target) / 2;
        int n = nums.length;
        //dp创建+初始化
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for(int j=1 ; j<=neg ; j++){
            dp[0][j] = 0;
        }
        //双层循环更新dp
        for(int i=1 ; i<=n ; i++){
            for(int j=0 ; j<=neg ; j++){
                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][neg];
    }
}
