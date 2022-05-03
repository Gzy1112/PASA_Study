/**
 * @author Gzy1112
 *  题目：买卖股票
 *  动态规划
 * f[i][0]-第i天结束后持有一支股票
 * f[i][1]-第i天结束后不持有股票，处于冷冻期
 * f[i][2]-第i天结束后不持有股票，且不处于冷冻期
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        //f[i][0]-第i天结束后持有一支股票
        //f[i][1]-第i天结束后不持有股票，处于冷冻期
        //f[i][2]-第i天结束后不持有股票，且不处于冷冻期
        if(prices.length == 0){
            return 0;
        }
        int[][] f = new int[prices.length][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for(int i=1 ; i<prices.length ; i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        return Math.max(Math.max(f[prices.length-1][0],f[prices.length-1][1]),f[prices.length-1][2]);
    }
}
