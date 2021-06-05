https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1

/*
Explanation:
Brute force:O(n^2)
Another approach will be Sorting (nlogn)
O(n) approach:
Test Case:
9
34 8 10 3 2 80 30 33 1

//For Intuition see editorial in gfg
We will create min and max array:
min array will be minimum elements at i in arr from o to ith index(current index)
max array will be maximum element at i  in arr from i to n-i-1 index
Basically in General min array will consist minimum till current index
and max array will contain maximum from end till current index
Test Case:
9
34 8 10 3 2 80 30 33 1

min array: 34  8  8  3  2  2  2  2  1
max array: 80 80 80 80 80 80 33 33  1 

Now we will use two pointer apparoach and increment i or j according to comparison of min[i] and max[j] (See code)

*/
class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff(int arr[], int n) { 
        int min[]=new int[n];
        int max[]=new int[n];
        int ans=0;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            low=Math.min(low,arr[i]);
            min[i]=low;
            high=Math.max(high,arr[n-i-1]);
            max[n-i-1]=high;
        }
        int i=0,j=0;
        while(j<n && i<n)
        {
            if(min[i]>max[j])
               i++;
            else
            {
                ans=Math.max(ans,j-i);
                j++;
            }
        }
        return ans;
    }
}