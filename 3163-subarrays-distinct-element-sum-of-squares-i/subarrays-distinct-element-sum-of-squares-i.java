class Solution {
    public int sumCounts(List<Integer> nums) {

        int n = nums.size();
        int sum =0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> distinctset = new HashSet<>();
            for(int j=i;j<n;j++)
            {
               distinctset.add(nums.get(j));

               int count = distinctset.size();

               sum += count*count;
            }
        }
       return sum; 
    }
}