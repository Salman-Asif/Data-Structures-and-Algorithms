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
    
    private TreeNode trim(TreeNode curNode,int low, int high) {
        if(curNode==null) return null;

        if(curNode.val < low)
            return trim(curNode.right, low, high);
        else if(curNode.val > high)
            return trim(curNode.left, low, high);
        
        curNode.left = trim(curNode.left, low, high);
        curNode.right = trim(curNode.right, low, high);
        return curNode;
    }
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        return trim(root, low, high);
    }
}