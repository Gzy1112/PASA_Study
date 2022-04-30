/**
 * @author Gzy1112
 * 题目：多数元素
 * 将数组中元素出现次数保存在哈希表中
 * 遍历键值对找出出现次数最多的数
 */
import java.util.HashMap;
import java.util.Map;

class LeetCode169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> counts = new HashMap<>(nums.length);
        for(int num : nums){
            if(counts.containsKey(num)){
                counts.put(num,counts.get(num)+1);
            }
            else{
                counts.put(num,1);
            }
        }
        int ans = nums[0];
        int maxCount = counts.get(ans);
        for(int key : counts.keySet()){
            if(counts.get(key)>maxCount){
                ans = key;
                maxCount = counts.get(key);
            }
        }
        return ans;
    }
}