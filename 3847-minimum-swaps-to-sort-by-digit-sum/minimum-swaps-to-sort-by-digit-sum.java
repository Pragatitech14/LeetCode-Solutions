
import java.util.*;

class Solution {

    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Make a copy of the original array
        Integer[] afterSorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            afterSorted[i] = nums[i];
        }

        // Step 2: Sort by digit sum, then by number
        Arrays.sort(afterSorted, (num1, num2) -> {
            int sum1 = getDigitSum(num1);
            int sum2 = getDigitSum(num2);

            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return Integer.compare(num1, num2);
        });

        // Step 3: Store each number's current index
        Map<Integer, Integer> valToIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            valToIdx.put(nums[i], i);
        }

        // Step 4: Put each number in its correct position
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            int expectedVal = afterSorted[i];
            int currVal = nums[i];

            if (expectedVal == currVal) {
                continue;
            }

            int idx = valToIdx.get(expectedVal);

            // Swap current value with the expected value
            nums[i] = expectedVal;
            nums[idx] = currVal;

            // Update both numbers' indices
            valToIdx.put(expectedVal, i);
            valToIdx.put(currVal, idx);

            swapCount++;
        }

        return swapCount;
    }
}
