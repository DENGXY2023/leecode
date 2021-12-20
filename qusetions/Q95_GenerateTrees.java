package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q95_GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i =start;i<=end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);
            for(TreeNode left:leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
