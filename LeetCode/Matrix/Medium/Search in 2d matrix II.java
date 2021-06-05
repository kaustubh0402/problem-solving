https://leetcode.com/problems/search-a-2d-matrix-ii/
//Problem no : 240

/*
Explanation:
As matrix is sorted rowwise and columnwise both
Input: matrix = 

Decreasing<--------
[1 ,4 ,7 ,11, 15]  | incresing
[2 ,5 ,8 ,12 ,19]  |
[3 ,6 ,9 ,16 ,22]  |
[10,13,14,17 ,24]  |
[18,21,23,26,30]]  \/
target = 5
Output: true
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(col>=0 && row<matrix.length)
        {
            int curr=matrix[row][col];
            if(curr==target)
                return true;
            else if(curr<target)
                row++;
            else
                col--;
        }
        return false;
    }   
}