/**
 * @author Gzy1112
 * 题目：买股票的最佳时机
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int x : prices){
            if(x < minPrice){
                minPrice = x;
            }
            else if(x - minPrice > maxProfit){
                maxProfit = x - minPrice;
            }
        }
        return maxProfit;
    }
}
