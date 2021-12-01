package qusetions;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q786_KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]);
        for(int i=1; i< arr.length; i++){
            pq.offer(new int[]{0,i});
        }
        for(int i=1; i<k; i++){
            int[] frac = pq.poll();
            if(frac[0]+1<frac[1]){
                pq.offer(new int[]{frac[0]+1,frac[1]});
            }
        }
        return new int[]{arr[pq.peek()[0]],arr[pq.peek()[1]]};
    }

    public static void main(String[] args) {
        Q786_KthSmallestPrimeFraction q786 = new Q786_KthSmallestPrimeFraction();
        int[] arr = {1,2,3,5};
        int[] a = q786.kthSmallestPrimeFraction(arr,3);
        System.out.println(a);


    }
}

