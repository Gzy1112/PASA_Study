/**
 * @author Gzy1112
 * 题目：最长连续序列
 * 利用hashset不重复元素的特点+hashset快速查找元素，不必遍历的特点
 */
import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numList = new HashSet<>(nums.length);
        //HashSet去除重复元素
        for (int num : nums) {
            numList.add(num);
        }
        int maxLen = 0;
        for (int num : numList) {
            if (!numList.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (numList.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            }
        }
        return maxLen;
    }
}

