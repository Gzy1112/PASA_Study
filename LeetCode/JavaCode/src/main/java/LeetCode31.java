/**
 * @author Gzy1112
 * 题目：下一个排列
 * 交换[较小数]和[较大数]
 * 较小数尽量靠右，较大数可能小
 */

class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找[较小数]，较小数尽可能靠右，从后向前找
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        //[i+1,n)降序 
        //nums[i] < nums[i+1] >= nums[i+2] >= nums[i+3] >= ... >= nums[n-1]
        //找[较大数]，较大数尽可能小，从后向前找
        //找到了[较小数]，若i == -1，说明整个数组倒序
        if(i >= 0){
            int j = nums.length - 1;
            while(j>=i+1 && nums[i] >= nums[j]){
                j--;
            }
            //交换[较小数]和[较大数]
            swap(nums,i,j);
        }

        //[i+1,n)重新排序
        reverse(nums,i+1);
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int begin){
        int left = begin;
        int right = nums.length - 1;
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}