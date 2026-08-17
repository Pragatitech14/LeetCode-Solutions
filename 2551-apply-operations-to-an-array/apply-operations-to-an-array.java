class Solution {
    public int[] applyOperations(int[] nums) {

        // Step 1: Apply operations
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move all non-zero elements to front
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }
}