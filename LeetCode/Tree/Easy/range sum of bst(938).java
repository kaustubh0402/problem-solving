https://leetcode.com/problems/range-sum-of-bst/
//problem no: 938

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
    int sum;
    Solution()
    {
        sum=0;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        rangeSumBST(root.right,low,high);
        rangeSumBST(root.left,low,high);
        if(root.val>=low && root.val<=high)
            sum+=root.val;
        return sum;
    }
}