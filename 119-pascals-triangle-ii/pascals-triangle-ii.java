class Solution {
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