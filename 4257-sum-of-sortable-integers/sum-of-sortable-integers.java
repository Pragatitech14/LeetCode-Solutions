import java.util.*;

class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int result = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int[] vec1 = Arrays.copyOfRange(nums, start, start + k);
                int[] vec2 = Arrays.copyOfRange(sorted, start, start + k);

                if (!isRotationPossible(vec1, vec2)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result += k;
            }
        }

        return result;
    }

    private boolean isRotationPossible(int[] vec1, int[] vec2) {
        int k = vec1.length;

        // Create vec2 + vec2
        int[] text = new int[2 * k];

        for (int i = 0; i < k; i++) {
            text[i] = vec2[i];
            text[i + k] = vec2[i];
        }

        // Check whether vec1 exists in vec2 + vec2 using KMP
        return kmpSearch(text, vec1);
    }

    private boolean kmpSearch(int[] text, int[] pattern) {
        int n = text.length;
        int m = pattern.length;

        int[] lps = new int[m];
        computeLPS(pattern, lps);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            } else if (i < n && text[i] != pattern[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private void computeLPS(int[] pattern, int[] lps) {
        int len = 0;
        int i = 1;

        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}