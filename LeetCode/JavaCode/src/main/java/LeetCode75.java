/**
 * @author Gzy1112
 *题目：颜色分类
 * 遍历一遍-双指针
 * p0标记-0 p1标记-1
 * p0用来交换0，p1用来交换1
 * 交换0时，p0,p1都要往后移，交换1时，只后移p1，
 * 若交换0时，p0<p1说明，p0现所指的元素为1，交换后，1跑到后面取了，再要和p1交换一次
 */
class LeetCode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for(int i=0 ; i<n ; i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0<p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }
}