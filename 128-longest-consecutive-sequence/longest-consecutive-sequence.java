class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int count=0;
        int lastsmallelement = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1==lastsmallelement)
            {
             count++;
             lastsmallelement=nums[i];
            }
            else if(lastsmallelement != nums[i])
            {
                lastsmallelement=nums[i];
                count =1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}