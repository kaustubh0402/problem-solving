https://leetcode.com/problems/symmetric-tree/
//Problem no : 101

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
    public boolean isSymmetric(TreeNode root) {
        return mirror(root,root);
    }
    
    public boolean mirror(TreeNode r1,TreeNode r2)
    {
        if(r1==null && r2==null)
            return true;
        if(r1==null || r2==null)
            return false;
        boolean lf=mirror(r1.left,r2.right);
        boolean rg=mirror(r1.right,r2.left);
        return (r1.val==r2.val && lf && rg);
    }
}

//iterative solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue <TreeNode> q =new LinkedList<>();
        if(root==null)
            return true;
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null && t2==null)
                continue;
            if(t1==null || t2==null)
                return false;
            if(t1.val!=t2.val)
                return false;
            q.offer(t1.left);
            q.offer(t2.right);
            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }
}