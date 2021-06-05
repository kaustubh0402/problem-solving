https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//problem no : 373

/*
Similar problem like merge k sorted array
Basic idea: Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the data structure.
We will create min heap of object or array
1. elemnt from num1
2. elemnt form num2
3. index of elemnt of num2

Now why above structure??
first we will create priority queue of object of num[0] and all elemnt from num2 upto k objects
Now after removing smallest sum from heap form object we will get index of elemnt from array num2 and current index
Now we will push next pair of elemnt from num1 and elemnt from nums2 of index current index+1 

The run time complexity is O(kLogk) since que.size <= k and we do at most k loop.
*/


class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        if(k==0 || nums1.length==0 || nums2.length==0)
            return ans;
        PriorityQueue<int[]> q=new PriorityQueue<>((x,y)->(x[0]+x[1])-(y[0]+y[1]));
        for(int i=0;i<nums1.length && i<k ;i++)
        {
            q.offer(new int[]{nums1[i],nums2[0],1});
        }
        
        while(!q.isEmpty() && k!=0)
        {
            int curr[]=q.poll();
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(curr[0]);
            temp.add(curr[1]);
            ans.add(temp);
            if(curr[2]!=nums2.length)
                q.offer(new int[]{curr[0],nums2[curr[2]],curr[2]+1});
            k--;
        }
        return ans;
    }
}
