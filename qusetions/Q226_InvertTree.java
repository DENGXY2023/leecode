package qusetions;
// 反转二叉树
public class Q226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;
        return root;
    }
}
