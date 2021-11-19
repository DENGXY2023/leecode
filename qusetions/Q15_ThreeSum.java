package qusetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int k = nums.length-1;
            for(int j=i+1;j< nums.length;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j<k && nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                if(j==k){
                    break;
                }
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    results.add(result);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Q15_ThreeSum q15 = new Q15_ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(q15.threeSum(nums).size());
    }
}
