https://leetcode.com/problems/binary-tree-right-side-view/
//problem no : 199

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> s=new LinkedList<>();
        List<Integer> in=new ArrayList<>();
        if(root!=null)
            s.add(root);
        int h=0;
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
            // if(!in.isEmpty())
               ans.add(in.get(in.size()-1));
            in=new ArrayList<>();
        }
        return ans;
    }
}