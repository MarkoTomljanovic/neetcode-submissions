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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // search for value right
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // search for value left
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // found the value
        else {
            // node with 0 or 1 child
            if (root.left == null) {
                return root.right;
            }
            // node with 0 or 1 child
            else if (root.right == null) {
                return root.left;
            }
            // node with 2 children
            else {
                TreeNode minNode = findMin(root.right);
                // root value is min node value
                root.val = minNode.val;
                // we created duplicate so this value now has to be removed
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
    public TreeNode findMin(TreeNode root) {
        TreeNode curr = root;

        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}