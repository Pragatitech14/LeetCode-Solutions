class Solution {
    public List<List<Integer>> generate(int numRows) {
         ArrayList<List<Integer>> finalList = new ArrayList<>();

        for(int i=0;i<numRows;i++)
        {
           finalList.add(getRow(i));
        }
        return finalList;
    }
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();

       int n =rowIndex+1;
        long ans =1;
        list.add((int) ans);
        for(int i=1;i<=rowIndex;i++)
        {
           ans = ans*(n-i);
           ans=ans/i;
           list.add((int)ans);
        }
        return list;
    }
}