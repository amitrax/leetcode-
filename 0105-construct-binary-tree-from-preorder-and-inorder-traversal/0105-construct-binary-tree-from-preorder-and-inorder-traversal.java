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
    public TreeNode helper(int[] preorder,int prelow,int prehigh,int []inorder,int inlow,int inhigh){
        if(prelow>prehigh){
            return null;
        }
        int i=inlow;
        TreeNode root=new TreeNode(preorder[prelow]);
        while(preorder[prelow]!=inorder[i]) i++;
        int left=i-inlow;
        root.left=helper(preorder,prelow+1,prelow+left,inorder,inlow,i-1);
        root. right=helper(preorder,prelow+left+1,prehigh,inorder,i+1,inhigh);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}