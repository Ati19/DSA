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
    
    int INT_MIN=Integer.MIN_VALUE;
    int INT_MAX=Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
       
       return validate(root,INT_MIN,INT_MAX);
    }
    private boolean validate(TreeNode root,int min,int max){
        if(root==null) return true;

        else if(root.val<=min || root.val>=max)
        return false;

        return validate(root.left,min,root.val) && validate(root.right,root.val,max);

    }
}
