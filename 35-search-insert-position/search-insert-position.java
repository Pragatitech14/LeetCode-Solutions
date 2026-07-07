class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }

        
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Output: " + sol.searchInsert(nums1, target1)); 

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Output: " + sol.searchInsert(nums2, target2)); 

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Output: " + sol.searchInsert(nums3, target3)); 
    }
}
