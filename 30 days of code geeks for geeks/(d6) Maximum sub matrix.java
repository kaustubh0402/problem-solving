https://www.geeksforgeeks.org/print-maximum-sum-square-sub-matrix-of-given-size/
Given an N x N matrix, find a k x k submatrix where k <= N and k >= 1,
 such that sum of all the elements in submatrix is maximum. 
 The input matrix can contain zero, positive and negative numbers.

//Wrobg solution
class Solution
{
    public int Maximum_Sum(int mat[][],int N,int k){
        int hor[][]=new int[N][N];
        int ver[][]=new int[N][N];
        if(k>N)
          return -1;
        for(int i=0;i<N;i++)
            ver[0][i]=mat[0][i];
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                ver[i][j]=ver[i-1][j]+mat[i][j];
                if(i>=k)
                    ver[i][j]-=mat[i-k][j];
            }
        }
        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         System.out.print(ver[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int max=Integer.MIN_VALUE;
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                ver[j][i]+=ver[j][i-1];
                if(i>=k)
                    ver[j][i]-=ver[j][i-k];
            }
        }
        
        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         System.out.print(ver[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i=N-1;i>k-2;i--)
        {
            for(int j=N-1;j>k-2;j--)
            {
                max=Math.max(max,ver[i][j]);
            }
        }
        return max;
    }
}
