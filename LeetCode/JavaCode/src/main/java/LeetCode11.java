/**
 * @author Gzy1112
 * 题目：盛最多水的容器
 * 方法一：双指针
 * 总是移动短的那根杆子
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        //左指针
        int l = 0;
        //右指针
        int r = height.length - 1;
        // 记录容量
        int ans = 0;
        //双指针移动
        while(l < r){
            int area = Math.min(height[l],height[r]) * (r - l);
            ans = Math.max(ans,area);
            //较短的栏杆被丢弃
            if(height[l] >= height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return ans;
    }
}
