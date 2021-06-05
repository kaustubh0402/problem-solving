https://leetcode.com/problems/binary-tree-level-order-traversal/
//Problem no : 102

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 /*
 BFS Solution
 Advantage is no additional 2d arraylist required as we can print immediate result...
 Here in level order traversal main aim is to find how manyy nodes in Particular level...
 Suppose if it is complete binary tree then nodes in each level=2^level height..
 but in binary tree it is not necessary to be 2^level
 So to find nodes in each level:
   Before pushing children node of current nodes present in Queue we will find Queue size 
   that will be our number of nodes for current level
 
 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> s=new LinkedList<>();
        if(root!=null)
            s.add(root);
        List<Integer> in=new ArrayList<>();
        while(!s.isEmpty())
        {
            int sz=s.size();
            TreeNode curr;
            for(int i=0;i<sz;i++)
            {
                curr=s.poll();
                if(curr.left!=null)
                    s.add(curr.left);
                if(curr.right!=null)
                    s.add(curr.right);
                in.add(curr.val);
            }
            ans.add(in);
            in=new ArrayList<>();
        }
        return ans;
    }
}

/*
DFS Solution :
Necessary we required 2d ArrayList..
As we are not storing immediate nodes in level order..
Here we are just doing pre order(can use any DFS ) traversal.
Instead of pushing we are maintaining height of particular node..
and adding that element into arraylist of index equal to height of node..

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans =new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,ans,0);
        return ans;
    }
    
     public void helper(TreeNode root,List<List<Integer>> ans, int h)
     {
         if(root==null)
             return;
         if(h==ans.size())
             ans.add(new ArrayList<>());
         ans.get(h).add(root.val);
         if(root.left!=null)
             helper(root.left,ans,h+1);
         if(root.right!=null)
             helper(root.right,ans,h+1);
     }
}