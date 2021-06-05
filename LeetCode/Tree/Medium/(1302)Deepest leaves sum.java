https://leetcode.com/problems/deepest-leaves-sum/
//Problem no : 1302

/*
Explanation:
Slightly modification of level order traversal of tree

BFS Solution
Here in level order traversal main aim is to find how manyy nodes in Particular level...
Suppose if it is complete binary tree then nodes in each level=2^level height..
but in binary tree it is not necessary to be 2^level
So to find nodes in each level:
   Before pushing children node of current nodes present in Queue we will find Queue size 
   that will be our number of nodes for current level
*/


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int sum=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            sum=0;
            for(int i=0;i<sz;i++)
            {
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }
        return sum;
    }
}

/*
DFS Solution :
Here we are just doing pre order(can use any DFS ) traversal.
Instead of pushing we are maintaining height of particular node..
and adding that element into arraylist of index equal to height of node..
we will maintain max height  and sum of nodes at max height
Suppose if we find new height greater than max height 
Then update max height and update sum as 0 (as we found new max(deepest height)
*/


class Solution {
    int sum=0;
    int mxlevel=0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root,0);
        return sum;
    }
    
    public void helper(TreeNode root,int height)
    {
        if(root==null)
            return ;
        if(mxlevel<height)
        {
            mxlevel=height;
            sum=0;
        }
        if(mxlevel==height)
            sum+=root.val;
        helper(root.left,height+1);
        helper(root.right,height+1);
    }
}
