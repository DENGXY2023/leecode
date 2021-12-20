package qusetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(res, nums, isUsed, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, boolean[] isUsed, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i< nums.length;i++){
            if(isUsed[i]||(i>0&&nums[i]==nums[i-1]&&!isUsed[i-1])){
                continue;
            }
            curr.add(nums[i]);
            isUsed[i] = true;
            backTrack(res, nums, isUsed,curr);
            curr.remove(curr.size()-1);
            isUsed[i] = false;

        }
    }
    public static void main(String[] args) {
        Q47_PermuteUnique q47 = new Q47_PermuteUnique();
        int[] nums = {1,1,2};
        List<List<Integer>> res = q47.permuteUnique(nums);
        System.out.println(res);
    }
    
}
