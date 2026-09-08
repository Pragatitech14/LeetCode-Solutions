class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
       ArrayList<Integer> mappos = new ArrayList<>();
       ArrayList<Integer> mapNeg = new ArrayList<>();

       for(int i=0;i<nums.length;i++)
       {
        if(nums[i]>=0)
        {
            mappos.add(nums[i]);
        }
        else
        {
           mapNeg.add(nums[i]);
        }
       }
       int j=0;
       for(int i=0;i<nums.length;i++)
       {
        if(i%2==0)
         {
           int temp = mappos.get(j);
           nums[i]=temp;
         }
         else
         {
            int temp = mapNeg.get(j);
            nums[i]=temp;
            j++;
         }
       }
         return nums;
    }
}