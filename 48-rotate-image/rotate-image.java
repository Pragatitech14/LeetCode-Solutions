class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int col=matrix[0].length;
        int[][] ans = new int[n][col];
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                ans[j][(n-1)-i] = matrix[i][j];
            }
        }

         for(int i=0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                matrix[i][j]=ans[i][j];
            }
        }
    }
}