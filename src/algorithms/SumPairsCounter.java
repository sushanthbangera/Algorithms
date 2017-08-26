package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sushanth Bangera
 */
public class SumPairsCounter {

    // To get the count of pairs of numbers in an array with positive numbers
    public int getSumPairsCount(int arr[], int sum) {
        int pairs = 0, len = arr.length;
        int tempArray[] = new int[sum + 1];
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (num <= sum) {
                int complement = sum - num;
                pairs += tempArray[complement];
                tempArray[num]++;
            }
        }
        return pairs;
    }

    // To get the count of pairs of numbers in an array
    public int getSumPairs(int arr[], int sum) {
        int pairs = 0, len = arr.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int a : arr) {
            if (!numMap.containsKey(a)) {
                numMap.put(a, 0);
            }
            numMap.put(a, numMap.get(a) + 1);
        }

        // Since its checking compliment for one pair count will be 2
        for (int i = 0; i < len; i++) {
            if (numMap.get(sum - arr[i]) != null) {
                pairs += numMap.get(sum - arr[i]);
            }

            // if (arr[i], arr[i]) pair satisfies the condition, then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i]) {
                pairs--;
            }
        }
        return pairs / 2;
    }

    // To get the count of pairs of numbers in an array of sorted positive numbers
    public int findSumPairs(int arr[], int n, int sum) {
        int pairs = 0;
        int low = 0, high = n - 1;

        while (low < high) {
            if (arr[low] + arr[high] > sum) {
                high--;
            } else if (arr[low] + arr[high] < sum) {
                low++;
            } else {
                pairs++;
                high--;
            }
        }
        return pairs;
    }
}
