package qusetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q740_DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<>();
        List<Integer> sortedNums = new ArrayList<>();

        sum.add(nums[0]);
        sortedNums.add(nums[0]);
        int size = 0;
        for(int i =1; i<nums.length; i++){
            int value = nums[i];
            if(value==nums[i-1]){
                sum.set(size, sum.get(size)+value);
            }
            else{
                size++;
                sum.add(value);
                sortedNums.add(value);
            }
        }
        if(sortedNums.size()==1){
            return sum.get(0);
        }
        int first = sum.get(0);
        int second = 0, dp=0;
        if(sortedNums.get(1)-sortedNums.get(0)==1){
            second = Math.max(sum.get(0), sum.get(1) );
        }
        else{
            second = sum.get(0)+sum.get(1);
        }
        if(sortedNums.size()==2){
            return second;
        }
        for(int i =2; i<sortedNums.size();i++){
            if(sortedNums.get(i)-sortedNums.get(i-1)==1){
                dp = Math.max(second,first+ sum.get(i));
            }
            else{
                dp = second+ sum.get(i);
            }
            first = second;
            second = dp;
        }
        return dp;
    }

    public static void main(String[] args) {
        Q740_DeleteAndEarn q740 = new Q740_DeleteAndEarn();
        int [] a = {2,2,3,3,3,4,1};
        System.out.println(q740.deleteAndEarn(a));
    }
}
