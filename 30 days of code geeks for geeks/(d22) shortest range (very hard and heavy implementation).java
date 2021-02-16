
/*
Given a BST (Binary Search Tree), find the shortest range [x, y], 
such that, at least one node of every level of the BST lies in the range.
If there are multiple ranges with the same gap (i.e. (y-x)) 
return the range with the smallest x.

Example 1:

Input:
              8
          /   \
         3     10
       /  \      \
      2    6      14
          / \     /
         4   7   12
                /  \
               11   13
Output: 6 11
Explanation: Level order traversal of the tree 
is [8], [3, 10], [2, 6, 14], [4, 7, 12], [11, 13]. 
The shortest range which satisfies the above 
mentioned condition is [6, 11]. 

Example 2:

Input:
   12
    \
     13
       \
        14
         \
          15
           \
           16

Output: 12 16
Explanation: Each level contains one node, 
so the shortest range is [12, 16].
*/

/*
Explanation:
Ver heavy implementation code
First we have to level order binary tree and input in List<List<Integer> input
And now we will use heap to find smallest range to find at least one element from list
*/

class myNode implements Comparable
{
    private int value;
    private int listNum;
    private int index;
 
    myNode(int value, int listNum, int index) {
        this.value = value;
        this.listNum = listNum;
        this.index = index;
    }
 
    public int getValue() {
        return value;
    }
 
    public int getListNum() {
        return listNum;
    }
 
    public int getIndex() {
        return index;
    }
 
    @Override
    public int compareTo(Object o) {
        myNode node = (myNode)o;
        return value - node.value;
    }
}


class Solution {
    public Range shortestRange(Node root) {
        List<List<Integer>> input=levelOrder(root);
        Range ans=findMinimumRange(input);
        return ans;
    }
    
    public Range findMinimumRange(List<List<Integer>> list)
    {
        int high = Integer.MIN_VALUE;
        Range p = new Range(0, Integer.MAX_VALUE);
        PriorityQueue<myNode> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++)
        {
            pq.add(new myNode(list.get(i).get(0), i, 0));
            high = Integer.max(high, list.get(i).get(0));
        }
        while (true)
        {
            myNode top = pq.poll();
            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();
            if (high - low < p.y- p.x) {
                p = new Range(low, high);
            }
            if (j == list.get(i).size() - 1) {
                return p;
            }
            pq.add(new myNode(list.get(i).get(j + 1), i, j + 1));
            high = Integer.max(high, list.get(i).get(j + 1));
        }
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> s=new LinkedList<>();
        if(root!=null)
            s.add(root);
        List<Integer> in=new ArrayList<>();
        while(!s.isEmpty())
        {
            int sz=s.size();
            Node curr;
            for(int i=0;i<sz;i++)
            {
                curr=s.poll();
                if(curr.left!=null)
                    s.add(curr.left);
                if(curr.right!=null)
                    s.add(curr.right);
                in.add(curr.data);
            }
            ans.add(in);
            in=new ArrayList<>();
        }
        return ans;
    }
}