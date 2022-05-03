/**
 * @author Gzy1112
 *  题目：比特位计数
 *  动态规划
 *  答题解析：
 *  https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
 */
public class LeetCode338 {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        int highBit = 0;
        for(int i=1 ; i<=n ; i++){
            if( (i & (i-1)) == 0){
                highBit = i;
            }
            bits[i] = bits[i-highBit] + 1;
        }
        return bits;
    }
}
