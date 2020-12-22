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