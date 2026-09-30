class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[m];

        for(int i =0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows[i]=true;
                    columns[j]=true;
                }
            }
        }

        for(int i =0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rows[i] || columns[j])
                {
                   matrix[i][j]=0;
                }
            }
        }
    }
}