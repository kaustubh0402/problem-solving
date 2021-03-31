https://leetcode.com/problems/all-paths-from-source-to-target/
//Problem no : 797

/*
Explanation:
We have to start form 0 and end at graph.length-1 node
Note that we have to print nodes index 
We have to find path so we will use DFS and Backtracking

Base condition will become true when we reach at last index (i.e. len-1)
Now one thing we have to notice that
if we reach at certain index let say i from previous index 
so we have to check all elemnts in i index
so our for loop will be from o to length of array at that index
Now we have to add i in list as we want index in answer4
and we will pass all elelments at index i in recursive call
*/


class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> curr=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph,0);
        return ans;
    }
    
    void helper(int graph[][],int index)
    {
        if(index==graph.length-1)
        {
            curr.add(index);
            ans.add(new ArrayList(curr));
            curr.remove(curr.size()-1);
            return;
        }
        
        for(int i=0;i<graph[index].length;i++)
        {
            curr.add(index);
            helper(graph,graph[index][i]);
            curr.remove(curr.size()-1);
        }
    }
}