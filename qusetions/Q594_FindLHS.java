package qusetions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q594_FindLHS {
    // 先排序，再遍历
    public int findLHS(int[] nums) {
        int len=1;
        int len2=0;
        int maxLen=0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                len++;
                if(len2>0){
                    len2++;
                }
                continue;
            }
            maxLen=Math.max(maxLen,len2);
            if(nums[i]==nums[i-1]+1){
                len2=len+1;
                maxLen=Math.max(maxLen,len2);
            }
            else{
                len2=0;
            }
            len=1;
        }
        maxLen=Math.max(maxLen,len2);
        return maxLen;
    }
    // 先遍历，滑动窗口求解
    public int findLHS_2(int[] nums) {
        int start = 0, end = 0;
        int maxLen=0;
        Arrays.sort(nums);
        for(end=0;end<nums.length;end++){
            if(nums[end]-nums[start]>1){
                start++;
            }
            if(nums[end]-nums[start]==1){
                maxLen = Math.max(maxLen, end-start+1);
            }
        }
        return maxLen;

    }
    // 哈希表
    public int findLHS_3(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> numsHM = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(!numsHM.containsKey(nums[i])){
                numsHM.put(nums[i],1);
            }
            else{
                numsHM.put(nums[i],numsHM.get(nums[i])+1);
            }
        }
        for(Integer key : numsHM.keySet()){
            if(numsHM.containsKey(key+1)){
                maxLen = Math.max(maxLen, numsHM.get(key)+numsHM.get(key+1));
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Q594_FindLHS q594 = new Q594_FindLHS();
        int[] nums = {2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2};
        int a =q594.findLHS_3(nums);
        System.out.println(a);
    }


}
