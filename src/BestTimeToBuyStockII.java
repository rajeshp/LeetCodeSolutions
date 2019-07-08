
/**
 *  Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 *  Explanation -
 *  count the low & highs. As long as
 *  price[i] > price[i-1] then it will be profit
 *
 *
 */
public class BestTimeToBuyStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                profit += (prices[i] - prices[i-1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyStockII obj = new BestTimeToBuyStockII();

        System.out.println("maxprofit= "+obj.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
