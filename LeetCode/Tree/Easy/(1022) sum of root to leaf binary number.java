https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//Problem no : 1022

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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder ans=new StringBuilder();
        helper(root,ans);
        return sum;
    }
    public void helper(TreeNode root,StringBuilder ans)
    {
        if(root!=null)
        {
            ans.append(root.val);
            if(root.left==null && root.right==null)
            {
                sum+=Integer.parseInt(ans.toString(),2);
                System.out.println(ans);
                ans.setLength(ans.length()-1); // For removing last appended char
                return;
            }
            helper(root.left,ans);
            helper(root.right,ans);
            ans.setLength(ans.length()-1);
        }
    }
}