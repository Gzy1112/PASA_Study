/**
 * @author Gzy1112
 * 题目：只出现一次的元素
 * 所有元素位运算，最终结果为出现一次的元素
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums){
            single = single ^ num;
        }
        return single;
    }
}
