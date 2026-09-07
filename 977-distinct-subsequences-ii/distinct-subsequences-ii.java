class Solution {
    public int distinctSubseqII(String s) {

        long MOD = 1000000007;

        // dp = number of distinct subsequences including ""
        long dp = 1;

        // last[c] = dp value before previous occurrence of c
        long[] last = new long[26];

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            long oldDp = dp;

            // Add current character to every existing subsequence
            dp = (dp * 2) % MOD;

            // Remove duplicates caused by previous occurrence
            dp = (dp - last[index] + MOD) % MOD;

            // Store the old dp for this character
            last[index] = oldDp;
        }

        // Remove the empty subsequence
        return (int)((dp - 1 + MOD) % MOD);
    }
}