/**
 * @author Gzy1112
 *  题目：前k个高频元素
 */
import java.util.HashMap;
import java.util.Map;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 结果数组
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap();
        // 统计数组中各元素出现的次数
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        // 出现最多的元素的出现次数
        int maxTimes = 0;
        // 找出出现次数最多的元素出现的次数
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxTimes){
                maxTimes = entry.getValue();
            }
        }

        // 按出现次数从大到小添加到结果数组
        while(k > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxTimes){
                    res[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }

        return res;
    }
}
