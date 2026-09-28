class Solution {
    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> list = new ArrayList<>();

        for(int r=1;r<=numRows;r++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int c=1;c<=r;c++)
            {
              temp.add(funnCr(r-1,c-1));
            }
            list.add(temp);
        }
       return list;  
    }
    public int funnCr(int r,int c)
    {
        int res = 1;
        for(int i=0;i<c;i++)
        {
            res = res*(r-i);
            res=res/(i+1);
        }
        return res;
    }
}