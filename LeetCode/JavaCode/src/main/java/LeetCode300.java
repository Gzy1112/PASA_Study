/**
 * @author Gzy1112
 *  题目：最长递增子序列
 *  动态规划
 *  dp[i] = max(dp[j]) + 1 (nums[j]<nums[i])(j=0,1,----,i-1)
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i=1 ; i<nums.length ; i++){
            dp[i] = 1;
            for(int j=0 ; j<i ;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
