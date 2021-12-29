package qusetions;

import java.util.PriorityQueue;

public class Q1705_EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int res=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = apples.length;
        for(int i=0;i<n;i++){
            while (!pq.isEmpty()&&pq.peek()[0]<=i){
                pq.poll();
            }
            int rottenDay = days[i]+i;
            int count = apples[i];
            if(count>0){
                pq.offer(new int[]{rottenDay, count});
            }
            if(!pq.isEmpty()){
                int[] arr = pq.peek();
                arr[1]--;
                if(arr[1]==0){
                    pq.poll();
                }
                res++;
            }
        }
        int i =n;
        while (!pq.isEmpty()){
            if(pq.peek()[0]<=i){
                break;
            }
            pq.poll();
            res++;
            i++;
        }
        return res;
    }
}
