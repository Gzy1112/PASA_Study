/**
 * @author Gzy1112
 *  题目：回文子串
 *  中心扩展法
 *  枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
 *  回文长度是奇数和回文长度是偶数的两种情况。
 *  如果回文长度是奇数，那么回文中心是一个字符；如果回文长度是偶数，那么中心是两个字符。
 *  长度为n的字符串生成2n-1组回文中心[li,ri]
 *  li = 取不超过i/2的最大整数
 *  ri = li + (i mod 2)
 *  0----2n-2遍历i
 *  将奇数和偶数两种情况结合起来
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0 ; i<2*n-1 ; i++){
            int l = i/2;
            int r = l + i%2;
            while(l>=0 && r<=n-1 && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
