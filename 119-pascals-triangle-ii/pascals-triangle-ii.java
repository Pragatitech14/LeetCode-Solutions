class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int c=0;c<=rowIndex;c++)
        {
            long res = 1;
        for(int i=0;i<c;i++)
        {
            res = res*(rowIndex-i);
            res=res/(i+1);
        }
        list.add((int)res);
        }
        return list;
    }
}