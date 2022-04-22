/**
 * @author Gzy1112
 *题目：最大子数组和
 * 动态规划
 * f(i)代表以i这个位置结尾的子数组
 * f(i) = max(f(i-1) + nums(i),nums(i))
 */
class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for(int x : nums){
            pre = Math.max(pre+x,x);
            ans = Math.max(ans,pre);
        }
        return ans;
    }
}