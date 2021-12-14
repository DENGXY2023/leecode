package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        preorder(root, "", res);
        return res;

    }
    private void preorder(TreeNode root, String currPath, List<String>res){
        if(root==null){
            return;
        }
        StringBuilder pathSb = new StringBuilder(currPath);
        pathSb.append(root.val);
        if(root.left==null&&root.right==null){
            res.add(pathSb.toString());
        }
        else{
            pathSb.append("->");
            preorder(root.left, pathSb.toString(), res);
            preorder(root.right,pathSb.toString(),res);
        }
    }
}
