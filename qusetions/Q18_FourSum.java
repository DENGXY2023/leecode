package qusetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length<4){
            return results;
        }
        for(int i=0; i<nums.length-3;i++){

            for(int j=0; j<nums.length-2;j++){
                int k=j+1, t=nums.length-1;
                int sum = 0;
                while(k<t){
                    sum = nums[i]+nums[j]+nums[k]+nums[t];
                    if(sum==target){
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[t]);
                        results.add(result);
                        results.add(result);
                    }
                    if(sum<target){
                        while(nums[k]==nums[k+1]){
                            k++;
                        }
                        k++;
                    }
                    else{
                        while(nums[t]==nums[t-1]){
                            t--;
                        }
                        t--;
                    }
                }

            }
        }
        return results;

    }
}
