/**
 * @author Gzy1112
 *题目：跳跃游戏
 * 贪心算法
 * 设想一下，对于数组中的任意一个位置 y，我们如何判断它是否可以到达？
 * 根据题目的描述，只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为 x + nums[x]，这个值大于等于 y，
 * 即 x + nums[x] ≥y，那么位置 y 也可以到达。
 *
 */
class LeetCode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for(int i = 0 ; i < n ; i++){
            if(i <= rightmost){
                rightmost = Math.max(rightmost,i+nums[i]);
                if(rightmost >= n+1){
                    return true;
                }
            }
        }
        return false;
    }
}