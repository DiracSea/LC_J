package Array;

public class BuyAndSell {
    public int maxProfit(int[] prices) {
        //if (prices.length == 0 || prices.length > 1000) return 0;
        int max_price = 0, sell = 0, gap = 0;
        Integer buy = Integer.MAX_VALUE;
        // List<Integer> buy = new ArrayList<Integer>();
        // buy.add(prices[0]);

        for (int i: prices) {
            gap = i - buy;
            if (gap > max_price)
                max_price = gap; // change sell price
            if (gap < 0)
                buy = i; // change buy price
        }
        return max_price;
    }
}
