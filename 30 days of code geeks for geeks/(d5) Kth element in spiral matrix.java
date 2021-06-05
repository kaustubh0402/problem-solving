https://practice.geeksforgeeks.org/problems/cd61add036272faa69c6814e34aa7007d5a25aa6/1

/*
Given a matrix of size N x M. 
You have to find the Kth element which 
will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.

Example 1:

Input: 
N = 3, M = 3, K = 4
A[] = {{1, 2, 3}, 
       {4, 5, 6}, 
       {7, 8, 9}}
Output: 
6
Explanation: Spiral traversal of matrix: 
{1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
is 6.
*/

//Not a clean code

class Solution
{
   
	public int findK(int a[][], int m, int n, int k)
	{
	       int count=0;
           for(int i=0;i<(m+1)/2;i++)
           {
              int j,h,l,t;
              for(j=i;j<n-i;j++)
              {
                  count++;
                  if(count==k)
                    return a[i][j];
              }
              j--;
              for(h=i+1;h<m-i && count<m*n;h++)
              {
                  count++;
                  if(count==k)
                    return a[h][j];
              }
              h--;
              for(l=n-i-2;l>=i&&count<m*n;l--)
              {
                  count++;
                  if(count==k)
                    return a[h][l];
              }
              l++;
              for(t=m-i-2;t>=i+1 && count<m*n;t--)
              {
                 count++;
                  if(count==k)
                    return a[t][l];
              }
           }
           return -1;
	}
	
}