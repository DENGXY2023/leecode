package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backTrack(res, nums, isUsed, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, boolean[] isUsed, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i< nums.length;i++){
            if(!isUsed[i]){
                curr.add(nums[i]);
                isUsed[i] = true;
                backTrack(res, nums, isUsed,curr);
                curr.remove(curr.size()-1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Q46_Permute q46 = new Q46_Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> res = q46.permute(nums);
        System.out.println(res);
    }

}
