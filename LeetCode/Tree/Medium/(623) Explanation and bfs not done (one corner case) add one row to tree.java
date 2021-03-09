https://leetcode.com/problems/add-one-row-to-tree/
//Problem no : 623


/*
Explanation and dfs code will be added soon


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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1)
        {
            TreeNode temp=new TreeNode(v,root,null);
            return temp;
        }
        helper(root,v,1,d-1);
        return root;
    }
    
    public void helper(TreeNode root,int v ,int row,int d)
    {
        if(root==null)
            return;
        helper(root.left,v,row+1,d);
        helper(root.right,v,row+1,d);
        if(row==d)
        {
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(v,left,null);
            root.right=new TreeNode(v,null,right);
        }
    }
}