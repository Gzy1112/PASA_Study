/**
 * @author Gzy1112
 *  题目：寻找重复数
 *  二分
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int ans = -1;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for(int i=0 ; i < len ; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt<=mid){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
