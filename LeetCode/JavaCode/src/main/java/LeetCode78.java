/**
 * @author Gzy1112
 *题目：子集
 * 假设[1,2,3]，0-代表选这个数，1-代表不选这个数
 * 000-[] 001-[3] 010-[2] 011-[2,3] 100-[1] 101-[1,3] 110-[1,2] 111-[1,2,3]
 * 2^n-1种选择
 *
 */
import java.util.ArrayList;
import java.util.List;

class LeetCode78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        //遍历每一种选择情况
        for(int mask=0 ; mask < (1<<n) ; mask++){
            //ArrayList.clear() 清空列表
            t.clear();
            //对每一种选择情况有n位，看每一位是否为1，第i位为1-代表第i个数被选择了，加入t中
            for(int i=0 ; i < n ; i++){
                //并集运算&求第i位是否为1
                if((mask & (1 << i)) != 0){
                    t.add(nums[i]);
                }
            }
            //ans.add时t需要new，不然指针会偏移，导致结果错误
            ans.add(new ArrayList<> (t));
        }
        return ans;
    }
}