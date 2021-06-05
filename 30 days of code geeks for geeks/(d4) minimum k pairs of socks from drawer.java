https://practice.geeksforgeeks.org/problems/620fb6456d6515faddd77050dfbf2821d7a94b8a/1

Number of minimum picks to get 'k' pairs of socks from a drawer

A drawer contains socks of n different colours.
The number of socks available of ith colour is given by a[i] where a is an array of n elements.
Tony wants to take k pairs of socks out of the drawer. 
However, he cannot see the colour of the sock that he is picking. 
You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that he can be absolutely sure, 
without seeing their colours, that he will have at least k matching pairs.
 
Input: N = 2, a[] = {4, 6}, K = 3
Output: 7
Explanation: The Worst case scenario after 6 
picks can be 3,3 or 1,5 or 5,1 of each 
coloured socks. Hence 7th pick will ensure 
3rd pair.


/*
Explanation:
(Not my Explanation) 
First you should calculate maximum no. of pairs that can be formed.

Then check if k > pairs then return -1;
because k pairs cannot be formed.

Then take out maximum pairs without exhausting any color and storing it in a variable 'less_pair',
means that if there are 6 socks of a color then you should consider only 2 pairs 
(because if you will take out 3 pairs then all socks will be exhausted).

Now, if k>less_pair :
'less_pair' pairs were picked already, so no. of socks picked = 2*less_pair
as less_pair pairs are not enough (i.e, not equal to k), so we need to take more socks, 
then we will take n more socks (i.e, 1 sock from each color), 
so now each color will have 1 or 0 sock remaining, 
then each new pick will complete a pair, therefore (k-less_pair) more picks are required

and if k <= less_pair:

let 'k-1' pairs are picked using 2*(k-1) socks, 
then you will take n pairs more (of unique colors) 
and if we will take one more pair it will complete the kth pair .


*/

class Solution {
    public int find_min(int[] a, int n, int k) {
        int pairs=0;
        int less_pair=0;
        for(int i=0;i<n;i++)
        {
            pairs+=a[i]/2;
            less_pair+=(a[i]-1)/2;
			/*
			Instead of above line you can write
			This is just for not using all pairs
			like if 6 then 2 pairs and 5 then 2 pairs
			*/
        }
        if(pairs<k)
          return -1;
        else if(less_pair>=k)
          return 2*(k-1)+n+1;
        return 2*less_pair+n+(k-less_pair);
    }
}