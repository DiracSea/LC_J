package Array;

public class BuyAndSellII {
    public int maxProfit(int[] prices) {
        /*
         * @Peak Valley Approach
         * Draw the graph, Sum all the rising curves!!!!
         * from day X, the buying day will be the last continuous day that the price is smallest. Then, the
         * selling day will be the last continuous day that the price is biggest.
         * [3, 2, 5, 8, 1, 9] will be splitted into 2 sub-ranges [3, 2, 5, 8] and [1, 9]
         */

        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];
            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }

    // Simple one Pass
}
