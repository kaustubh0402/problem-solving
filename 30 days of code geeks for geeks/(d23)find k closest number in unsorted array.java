https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/

/*
Lucy lives in house number X. She has a list of N house numbers in the society. 
Distance between houses can be determined by studying the difference between house numbers.
 Help her find out K closest neighbors.
Note: If two houses are equidistant and Lucy has to pick only one, 
the house with the smaller house number is given preference.

Example 1:

Input:
N = 5, X = 0, K = 4
a[] = {-21, 21, 4, -12, 20}, 
Output:
-21 -12 4 20
Explanation:
The closest neighbour is house
number 4. Followed by -12 and 20. -21 and 21 
are both equal distance from X=0. Therefore, 
Lucy can only pick 1. Based on the given 
condition she picks -21 as it is the smaller 
of the two. 
*/


class Solution 
{ 
    class pair
    {
        int diff,val;
        pair(int x,int y)
        {
            diff=x;
            val=y;
        }
    }
    static class sorting implements Comparator<pair>
    {
        public int compare(pair x,pair y)
        {
            if(x.diff==y.diff)
            {
                if(x.val==y.val)
                  return 0;
                else if(x.val>y.val)
                  return 1;
                else
                  return -1;
            }
            else if(x.diff>y.diff)
              return 1;
            return -1;
        }
    }
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	    PriorityQueue<pair> q=new PriorityQueue<>(new sorting());
	    for(int i=0;i<n;i++)
	      q.offer(new pair(Math.abs(x-arr[i]),arr[i]));
	    ArrayList<Integer> ans = new ArrayList<>();
	    for(int i=0;i<k;i++)
	      ans.add(q.poll().val);
	    Collections.sort(ans);
	    return ans;
	}
}