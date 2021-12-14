package qusetions;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeTraversal {
    // 二叉树前序遍历
    // 方法1，递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
    // 方法2，迭代
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode curr = root;
        while(curr!=null||!stk.isEmpty()){
            while(curr!=null){
                stk.push(curr);
                res.add(curr.val);
                curr=curr.left;
            }
            curr = stk.pop();
            curr = curr.right;
        }
        return res;
    }
    // 二叉树中序遍历
    // 方法1，递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    // 方法2，迭代
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode curr = root;
        while(curr!=null||!stk.isEmpty()){
            while(curr!=null){
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // 二叉树后序遍历
    // 方法1，递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    private void postorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
    // 方法2，迭代
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr!=null||!stk.isEmpty()){
            while(curr!=null){
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            if(curr.right==null||curr.right==prev){
                res.add(curr.val);
                prev = curr;
                curr = null;
            }
            else{
                stk.push(curr);
                curr=curr.right;
            }
        }
        return res;
    }
    // 二叉树层序遍历
    // 广度优先搜素，迭代，堆
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> stk = new LinkedList<>();
        if(root==null){
            return res;
        }
        stk.offer(root);
        while(!stk.isEmpty()){
            List<Integer> levelRes = new ArrayList<>();
            int currentLevelLength = stk.size();
            for(int i=0;i<currentLevelLength;i++){
                TreeNode curr = stk.poll();
                levelRes.add(curr.val);
                if(curr.left!=null){
                    stk.offer(curr.left);
                }
                if(curr.right!=null){
                    stk.offer(curr.right);
                }
            }
            res.add(levelRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeTraversal q94 = new TreeTraversal();
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
        List<Integer> res = q94.postorderTraversal(root);
    }
}
