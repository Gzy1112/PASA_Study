
/**
 * @author Gzy1112
 * 题目：在排序数组中查找元素的第一个位置和最后一个位置
 * 先找>=target的第一个
 * 再找>target的第一个
 */
class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums,target);
        int r = search(nums,target+1);
        if(l==nums.length || nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r-1};
    }
    public int search(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}