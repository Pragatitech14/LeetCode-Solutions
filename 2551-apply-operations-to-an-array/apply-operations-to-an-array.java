class Solution {
    public int[] applyOperations(int[] nums) {

        // Step 1: Apply operations
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move non-zero elements to the front
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        return nums;
    }
}