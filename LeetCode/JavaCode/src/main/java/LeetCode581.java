/**
 * @author Gzy1112
 *  题目：最短无序连续子数组
 *  方法一：假设数组被分为numsA，numsB，numsC三段
 *  numsB重新排序后，整体数组有序
 *  要求最短的numsB，即求最长的numsA和numsC
 *  将初始的数组与排好序的数组进行比较，确立最长的相同的numsA和numsB，确立左右边界
 *  方法二：numsA中任意一个数逗比numsB和numsC中任意一个数小
 *  numsC中任意一个数都比numsA和numsB中任意一个数大
 *  在numsB和numsC中找最小的数，在numsA和numsB中找最大的数
 *  从后往前，找这个最小的数插在哪里
 *  从前往后，找这个最大的数插在哪里
 *  思路详见图：https://pic.leetcode-cn.com/1627957087-VYaluV-%E6%9C%80%E7%9F%AD%E6%97%A0%E5%BA%8F%E8%BF%9E%E7%BB%AD%E5%AD%90%E6%95%B0%E7%BB%84%E9%A2%98%E8%A7%A3.png
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE;
        int minm = Integer.MAX_VALUE;
        int right = -1;
        int left = -1;
        for(int i=0 ; i<n ; i++){
            if(nums[n-i-1] > minm){
                left = n-i-1;
            }
            else{
                minm = nums[n-i-1];
            }
            if(nums[i] < maxn){
                right = i;
            }
            else{
                maxn = nums[i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
