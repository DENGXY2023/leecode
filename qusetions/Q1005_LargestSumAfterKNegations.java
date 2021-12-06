package qusetions;

import java.util.Arrays;

public class Q1005_LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum=0;
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        while(k>0){
            if(nums[i]<0){
                nums[i] = -nums[i];
                i++;
            }
            else{
                if(i>0||nums[i]>nums[i-1]){
                    i--;
                }
                nums[i] = -nums[i];
            }
            k--;
        }
        for(int j=0;j<n;j++){
            sum+=nums[j];
        }
        return sum;
    }
}
