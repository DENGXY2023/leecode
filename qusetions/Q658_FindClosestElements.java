package qusetions;

import java.util.List;
import java.util.PriorityQueue;

public class Q658_FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[][] arrDis = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){

        }
        queue.offer(new int[]{arr[0], Math.abs(arr[0]-x)});
        while(k>0)

    }
}
