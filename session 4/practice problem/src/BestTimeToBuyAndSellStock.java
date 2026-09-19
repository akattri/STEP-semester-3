import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit achievable from buying on one day and selling on a later day.
     * Traverses the array in a single pass, tracking the lowest price seen so far and the maximum profit.
     *
     * @param prices daily stock prices
     * @return maximum profit, or 0 if no profit is possible
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        // Walk through the array once
        for (int i = 1; i < prices.length; i++) {
            // Check if current price is lower than minPrice seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Input: prices = " + Arrays.toString(prices1));
        System.out.println("Output: " + profit1);

        // Sample Test Case 2: Only decreasing prices
        int[] prices2 = {7, 6, 4, 3, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("\nInput: prices = " + Arrays.toString(prices2));
        System.out.println("Output: " + profit2);

        // Additional Test Case
        int[] prices3 = {2, 4, 1};
        int profit3 = maxProfit(prices3);
        System.out.println("\nInput: prices = " + Arrays.toString(prices3));
        System.out.println("Output: " + profit3);
    }
}
