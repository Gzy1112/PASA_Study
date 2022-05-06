/**
 * @author Gzy1112
 *  题目：和为k的子数组
 *  前缀和+哈希表
 *  [j...i]之和为k，即pre[i]-pre[j-1]=k
 *  即pre[j-1] = pre[i] - k
 *  考虑以 i结尾的和为 k的连续子数组个数-->即求解有多少个前缀和为pre[i]-k的pre[j]
 *  建立哈希表mp，记录pre[i]出现的次数（pre[i]为键，次数为值）
 *  寻找mp[pre[i]-k]进行累加
 */
import java.util.HashMap;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer,Integer> mp = new HashMap<>(nums.length+1);
        mp.put(0,1);
        for(int num : nums){
            pre = pre + num;
            if(mp.containsKey(pre-k)){
                count = count + mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
