class Solution {

    int start = 0;
    int maxLen = 1;

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0)
            return "";

        for (int i = 1; i < s.length(); i++) {

            // Even length palindrome
            expand(s, i - 1, i);

            // Odd length palindrome
            expand(s, i - 1, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }

            left--;
            right++;
        }
    }
}