package qusetions;

import java.util.LinkedList;
import java.util.Queue;

public class Q559_MaxDepth {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        else{
            int maxHeight = 0;
            for(Node sonNode : root.children){
                int sonHeight = maxDepth(sonNode);
                maxHeight = Math.max(maxHeight, sonHeight);
            }
            return maxHeight+1;
        }
    }
    public int maxDepth_2(Node root) {
        if(root == null){
            return 0;
        }
        int ans =0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                Node node = queue.poll();
                if (!node.children.isEmpty()){
                    for(Node child : node.children){
                        queue.offer(child);
                    }
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
