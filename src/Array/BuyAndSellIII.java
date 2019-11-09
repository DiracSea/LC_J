package Array;

public class BuyAndSellIII {
    // 1,2,3,4,5 : should be 4 but get 3?????????
    public int maxProfit(int[] prices) {
        // dp
        int k_max = 2, n = prices.length;
        if (n == 0) return 0;

        int[][][] dp = new int[n][k_max+1][2];

        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][1][1] = dp[i][2][1] = Integer.MIN_VALUE;
                dp[i][1][0] = dp[i][2][0] = 0;
                continue;
            }
            //dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            //dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);

            dp[i][1][1] = Math.max(dp[i-1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);

            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);

        }
        return dp[n-1][k_max][0];
    }
}
