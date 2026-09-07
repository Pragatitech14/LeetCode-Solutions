class Solution {
    public int majorityElement(int[] nums) 
    {
        int n = nums.length;
        int element=0;
        int count =0;
      for(int i=0;i<n;i++) 
      {

        if(count==0)
        {
          element=nums[i];
          count=1;
        }
        else
        {
            if(nums[i]==element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }

      } 
      int cnt1=0; 
      for(int i=0;i<n;i++)
      {
        if(element==nums[i]) cnt1++;
      }
      if(cnt1>n/2)
        {
            return element;
        }
      return 0;
    }
}