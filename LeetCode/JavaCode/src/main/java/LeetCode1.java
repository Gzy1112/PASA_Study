import java.util.HashMap;
import java.util.Map;

/**
 * @author Gzy1112
 * 方法一：暴力求解
 * 方法二：哈希表HashMap
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] r = twoSum(nums,target);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        //返回一个长度为0的int数组
        return new int[0];
    }
}
