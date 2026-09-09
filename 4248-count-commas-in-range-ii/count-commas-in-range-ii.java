class Solution {
    public long countCommas(long n) {

        long count = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {

            long end = Math.min(n, start * 1000 - 1);

            count += (end - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return count;
    }
}