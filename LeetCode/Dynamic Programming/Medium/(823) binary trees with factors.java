https://leetcode.com/problems/binary-trees-with-factors/
//Problem no : 823

/*
sort the array and use HashMap to record each Integer, and the number of trees with that Integer as root
(1) each integer A[i] will always have one tree with only itself
(2) if A[i] has divisor (a) in the map, and if A[i]/a also in the map
     then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree;
     the number of such tree is map.get(a) * map.get(A[i]/a)
(3) sum over the map

Note:
If the root node of the tree (with value v) has children with 
values x and y (and x * y == v),
 then there are map.get(x) * map.get(y) ways to make this tree.
*/


class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer,Long> h=new HashMap<>();
        int n=arr.length;
        int mod=1000000007;
        int ans=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        {
            long count=1L;
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j]==0 && h.containsKey(arr[i]/arr[j]))
                    count+=(h.get(arr[i]/arr[j])*h.get(arr[j]));
            }
            ans=(ans%mod+(int)(count%mod))%mod;
            h.put(arr[i],count);
        }
        return ans;
    }
}


