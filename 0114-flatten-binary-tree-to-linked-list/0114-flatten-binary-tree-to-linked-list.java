class Solution {
    public void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        TreeNode lefttree = root.left;
        TreeNode righttree = root.right;

        root.left = null;

        flatten(lefttree);
        flatten(righttree);

        root.right = lefttree;

        TreeNode temp = root;

        while(temp.right != null){
            temp = temp.right;
        }

        temp.right = righttree;
    }
}