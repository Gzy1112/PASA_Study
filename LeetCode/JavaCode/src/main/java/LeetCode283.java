/**
 * @author Gzy1112
 *  题目：移动零
 *  双指针
 *  左指针：已处理完毕序列尾部
 *  右指针：待处理序列头部
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums , int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
