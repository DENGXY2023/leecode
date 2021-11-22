package qusetions;

import java.util.LinkedList;
import java.util.Queue;

public class Q104_MaxDepth {
    // 深度优先搜索
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    // 广度优先搜索
    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> quene = new LinkedList<>();
        quene.offer(root);
        int ans =0;
        while (!quene.isEmpty()){
            int size = quene.size();
            while(size>0){
                TreeNode node = quene.poll();
                if(node.left!=null){
                    quene.offer(node.left);
                }
                if(node.right!=null){
                    quene.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
