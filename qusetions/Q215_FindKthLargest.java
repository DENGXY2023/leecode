package qusetions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int a = 0;
        Queue<Integer> quene = new LinkedList<>();
        for(int i =len-1;i>=0;i--){
            quene.offer(nums[i]);
        }
        System.out.println(quene.peek());
        while(k>0){
            a = quene.poll();
            while(quene.peek()==a){
                quene.poll();
            }
            k--;
        }
        return a;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        Q215_FindKthLargest q251 = new Q215_FindKthLargest();
        int a = q251.findKthLargest(nums,4);
    }
}
