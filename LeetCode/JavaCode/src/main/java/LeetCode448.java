/**
 * @author Gzy1112
 *  题目：找到所有数组中消失的数字
 *  滑动窗口
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int num : nums){
            int x = (num-1) % n;
            nums[x] = nums[x] + n;
        }
        for(int i=0 ; i<n ;i++){
            if(nums[i]<=n){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
