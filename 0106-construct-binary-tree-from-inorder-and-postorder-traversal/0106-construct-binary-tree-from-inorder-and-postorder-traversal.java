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
    public TreeNode helper(int []postorder,int postlow,int posthigh,int []inorder,int inlow, int inhigh){
        if(postlow>posthigh){
            return null;
        }
        TreeNode root=new TreeNode(postorder[posthigh]);
        int i=inlow;
        while(postorder[posthigh]!=inorder[i]) i++;
        int left=inlow;
        int j=i-inlow-1;
        root.left=helper(postorder,postlow,postlow+j,inorder,inlow,i-1);
        root.right=helper(postorder,postlow+j+1,posthigh-1,inorder,i+1,inhigh);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        return helper(postorder,0,n-1,inorder,0,n-1);
    }
}