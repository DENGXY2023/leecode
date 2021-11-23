package qusetions;

import java.util.Arrays;

public class Q16_ThreeSumClosest {
    // 排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumOfThreeNums = 0;
        int err = 0;
        int nearestSum = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            while(j<k){
                sumOfThreeNums = nums[i]+nums[j]+nums[k];
                err = sumOfThreeNums-target;
                if(err==0){
                    return target;
                }
                if(err<0){
                    j++;
                }
                else k--;
                // minErr = Math.min(minErr, Math.abs(err));
                // if(minErr == Math.abs(err)){
                //     nearestErr = err;
                // }
                if(Math.abs(err)<Math.abs(nearestSum-target)){
                    nearestSum = sumOfThreeNums;
                }
            }

        }
        return nearestSum;
    }
}
