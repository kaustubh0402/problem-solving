/*
In Doraland, people have unique Identity Numbers called D-id. 
Doraemon owns the most popular gadget shop in Doraland. 
Since his gadgets are in high demand and he has only K gadgets left 
he has decided to sell his gadgets to his most frequent customers only. 
N customers visit his shop and D-id of each customer is given in an array array[ ]. 
In case two or more people have visited his shop the same number of time 
he gives priority to the customer with higher D-id. Find the D-ids of people he sells his K gadgets to.

Example 1:

Input:
N = 6
array[] = {1, 1, 1, 2, 2, 3}
K = 2
Output: 
1 2
Explanation: 
Customers with D-id 1 and 2 are most 
frequent.
Example 2:

Input:
N = 8
array[] = {1, 1, 2, 2, 3, 3, 3, 4}
K = 2
Output: 
3 2
Explanation: People with D-id 1 and 2 have 
visited shop 2 times Therefore, in this 
case, the answer includes the D-id 2 as 2 > 1.
*/


class custom implements Comparable<custom>
{
    int id,freq;
    custom(int x,int y)
    {
        id=x;
        freq=y;
    }
    public int compareTo(custom c)
    {
        if(freq==c.freq)
        {
            if(id<c.id)
              return 1;
            else if(id>c.id)
              return -1;
            else
              return 0;
        }
        else if(freq>c.freq)
          return -1;
        return 1;
    }
    
}
class Solution
{
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(Integer val:array)
          h.put(val,h.getOrDefault(val,0)+1);
        PriorityQueue<custom> q=new PriorityQueue<>();
        for(Integer key:h.keySet())
           q.offer(new custom(key,h.get(key)));
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++)
          ans.add(q.poll().id);
        return ans;
    }
}

/*
O(n) solution
Using count sort...use 2 hashmap/or 1 hashmap and 1 array
*/

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int,int>dic;
        for(auto ele:nums){
            dic[ele]++;
        }
        map<int,set<int>>dic2;
        
        for(auto ele:dic){
            dic2[ele.second].insert(ele.first);
        }
        vector<int>ans;
        for(auto it=dic2.rbegin();it!=dic2.rend();it++){
            if(k==0)return ans;
            for(auto itt=it->second.rbegin();itt!=it->second.rend();itt++){
                if(k==0)return ans;
                ans.push_back(*itt);
                k--;
            }
        }
        return ans;
        
    }
};