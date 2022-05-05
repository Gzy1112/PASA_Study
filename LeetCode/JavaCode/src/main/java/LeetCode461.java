/**
 * @author Gzy1112
 *  题目：汉明距离
 *  异或运算+每次右移一位看最低位是否为1 （s&1）
 */
public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int count = 0;
        while(s!=0){
            if((s & 1) == 1){
                count++;
            }
            s = s >> 1;
        }
        return count;
    }
}
