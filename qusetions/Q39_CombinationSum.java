package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backTrack(results, candidates, target, 0, new ArrayList<>());
        return results;
    }
    public void backTrack(List<List<Integer>> results, int[] candidates, int target, int index, List<Integer> curr){
        if(index==candidates.length){
            return;
        }
        int sumOfCurr = sum(curr);
        if(sumOfCurr==target){
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        backTrack(results, candidates, target, index+1, curr);
        if(sum(curr)<target){
            curr.add(candidates[index]);
            backTrack(results, candidates, target, index, curr);
            curr.remove(curr.size()-1);
        }


    }
    public int sum(List<Integer> curr){
        int sum = 0;
        for(Integer a:curr){
            sum+=a;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q39_CombinationSum q39 = new Q39_CombinationSum();
        List<List<Integer>> results = new ArrayList<>();
        int[] candidates = {2,3,6,7};
        results = q39.combinationSum(candidates, 6);
        System.out.println(results);
    }
}
