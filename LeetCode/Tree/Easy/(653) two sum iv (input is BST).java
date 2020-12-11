https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//problem no : 653

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
    public boolean findTarget(TreeNode root, int k) {
        HashSet <Integer> store=new HashSet<Integer>();
        Queue <TreeNode> nodes=new LinkedList<TreeNode>();
        nodes.add(root);
        while(!nodes.isEmpty())
        {
                TreeNode temp=nodes.peek();
                if(store.contains(k-temp.val))
                    return true;
                store.add(temp.val);
                nodes.remove();
                if(temp.left!=null)
                   nodes.add(temp.left);
                if(temp.right!=null)
                   nodes.add(temp.right);
        }
        return false;
    }
}

Solution 2:

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}