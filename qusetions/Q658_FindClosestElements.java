package qusetions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q658_FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[1]-b[1]==0){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        List<Integer> res = new ArrayList<>();
        int[][] arrDis = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            queue.offer(new int[]{arr[i], Math.abs(arr[i]-x)});
        }
        while(k>0){
            res.add(queue.poll()[0]);
            k--;
        }
        res.sort((a,b)->a-b);
        return res;
    }
}
