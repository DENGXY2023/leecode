package qusetions;

public class Q653_FindTilt {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        tn.val =1;
        tn.left = new TreeNode();
        tn.right = new TreeNode();
        tn.left.val = 2;
        tn.right.val =3;
        Q653_FindTilt q653 = new Q653_FindTilt();
        int a = q653.findTilt(tn);
        System.out.println(a);
    }
}
