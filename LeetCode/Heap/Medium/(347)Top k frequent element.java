https://leetcode.com/problems/top-k-frequent-elements/
//Problem no : 347

//Best optimal code
//Bucket sort technique
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int val:nums)
            h.put(val,h.getOrDefault(val,0)+1);
        List<Integer>[] bucket=new List[nums.length+1];
        for(int i=0;i<bucket.length;i++)
            bucket[i]=new ArrayList<>();
        for(Integer key:h.keySet())
            bucket[h.get(key)].add(key);
        int ans[]=new int[k];
        int cnt=0;
        for(int i=bucket.length-1;k!=0;i--)
        {
            for(int j=0;j<bucket[i].size();j++)
            {
                ans[cnt]=bucket[i].get(j);
                cnt++;
                k--;
            }
        }
        return ans;
    }
}


//Heap Code
class Solution {
    class pair
    {
        
        int val;
        int freq;
        pair(int f,int v)
        {
            val=v;
            freq=f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int val:nums)
            h.put(val,h.getOrDefault(val,0)+1);
        int ans[]=new int[k];
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->b.freq-a.freq);
        for(Integer key:h.keySet())
            q.offer(new pair(h.get(key),key));
        int i=0;
        while(i!=k)
        {
            ans[i]=q.poll().val;
            i++;
        }
        return ans;
    }
}
```