
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] freq = new int[100001];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            max = Math.max(max, d);
        }

        long total = 0;
        for (int d = 1; d <= max; d++) {
            total += (long) d * freq[d];
        }

        if (k >= total) {
            return 0;
        }

        for (int d = max; d > 0 && k > 0; d--) {
            int count = freq[d];
            if (count == 0) continue;

            long operations = Math.min(k, (long) count);
            freq[d] -= (int) operations;
            freq[d - 1] += (int) operations;
            k -= operations;
        }

        long answer = 0;
        for (int d = 1; d <= max; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}
