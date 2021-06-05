https://practice.geeksforgeeks.org/problems/b6b608d4eb1c45f2b5cace77c4914f302ff0f80d/1

Given an array of size N, find the smallest positive integer value that cannot be represented as sum of some elements from the array.
Example 1:

Input: 
N = 6
array[] = {1, 10, 3, 11, 6, 15}
Output: 
2
Explanation:
2 is the smallest integer value that cannot 
be represented as sum of elements from the array.





class Solution { 
    long smallestpositive(long[] a, int n){ 
        Arrays.sort(a);
        long sum=1;
        for(int i=0;i<n;i++)
        {
            if(sum<a[i])
              return sum;
            sum+=a[i];
        }
        return sum;
    }
} 