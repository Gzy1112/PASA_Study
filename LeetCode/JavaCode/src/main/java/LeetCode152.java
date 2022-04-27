/**
 * @author Gzy1112
 * 题目：乘积最大子数组
 * 动态规划
 */
class LeetCode152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums,0,maxF,0,length);
        System.arraycopy(nums,0,minF,0,length);
        for(int i=1 ; i<length ; i++){
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i] = Math.min(maxF[i-1]*nums[i],Math.min(minF[i-1]*nums[i],nums[i]));
        }
        int ans = maxF[0];
        for(int i=1 ; i<length ; i++){
            ans = Math.max(ans,maxF[i]);
        }
        return ans;
    }
}