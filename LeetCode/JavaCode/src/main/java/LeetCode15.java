/**
 * @author Gzy1112
 * 题目：三数之和
 * 方法一：三重循环
 * 方法二：双指针
 * a + b + c = 0
 * b增大，则c一定减小
 * 为保证不出现重复的三元组，将数组进行排序
 * 保证输出结果的(a,b,c)三元组满足 a<=b<=c
 * 保证不会出现例如(a,c,b)的三元组
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //ArrayList数组
        List<List<Integer>> ans = new ArrayList<>();
        //Arrays.sort()
        Arrays.sort(nums);
        //对于int类型数组 .length为数组中元素个数
        for(int first = 0 ; first < nums.length ; first ++){
            if(first == 0 || nums[first] != nums[first-1]){
                //第三个参数从尾指针开始
                int third = nums.length - 1;
                for(int second = first + 1 ; second < third ; second ++){
                    if(second == first + 1 || nums[second] != nums[second-1]){
                        while(second < third && nums[first] + nums[second] + nums[third] > 0){
                            third -- ;
                        }
                        //若second = third,则表明此时不可能三数之和为0
                        if(second == third){
                            break;
                        }
                        if(nums[first] + nums[second] + nums[third] == 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[third]);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
