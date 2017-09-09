/*
 Stock Buy Sell to Maximize Profit
 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. 
 Again buy on day 4 and sell on day 6.
 If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class StockBestBuySell {

    final private List<StockIndex> indexList = new ArrayList<>();

    class StockIndex {

        int buyIndex;
        int sellIndex;
    }

    // Creates the list of Index Objects of Best buy and sell points
    private void addIndexList(int priceArray[], int len) {
        int i = 0;
        while (i < len - 1) {
            // Find the local minima - Buying stock when its price is low
            while (i < len && priceArray[i + 1] <= priceArray[i]) {
                i++;
            }

            if (i == len - 1) {
                break; // No profit
            }
            StockIndex stockObj = new StockIndex();
            stockObj.buyIndex = i++;

            // Find the local maxima - highest price to sell the stock
            while (i < len && priceArray[i] > priceArray[i - 1]) {
                i++;
            }
            stockObj.sellIndex = i - 1;
            indexList.add(stockObj);
        }
    }

    // Returns the Indexes of best buy and sell point in form of String
    public String getBuySellIndexList(int priceArray[]) {
        addIndexList(priceArray, priceArray.length);
        if (indexList.isEmpty()) {
            return "";
        }
        StringBuilder indices = new StringBuilder();
        indexList.stream().forEach((st) -> {
            indices.append("(").append(st.buyIndex).append(",").append(st.sellIndex).append(") ");
        });
        return indices.toString().trim();
    }

    public static void main(String[] args) {
        StockBestBuySell stock = new StockBestBuySell();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};

        // print the Indexes
        System.out.println(stock.getBuySellIndexList(price));
    }

}
