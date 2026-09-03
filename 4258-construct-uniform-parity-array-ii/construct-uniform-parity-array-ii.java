class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = nums1[0];

        // Find the smallest number
        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // If minimum is odd,
        // we can make every number odd.
        if (min % 2 != 0) {
            return true;
        }

        // Minimum is even.
        // Now every number must already be even.
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}