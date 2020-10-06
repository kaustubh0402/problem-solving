//https://leetcode.com/problems/matrix-diagonal-sum/
//Problem no :1572

class Solution {
    public int diagonalSum(int[][] mat) {
        int rows=mat.length;
        int col=mat[0].length;
        int sum=0;
        for(int i=0;i<rows;i++)
        {
            sum+=mat[i][i];
            sum+=mat[i][col-i-1];
        }
        if((rows & 1)==1)
            sum-=mat[rows/2][rows/2];
        return sum;
    }
}