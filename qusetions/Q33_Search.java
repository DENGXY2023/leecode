package qusetions;

import java.util.HashMap;
import java.util.Map;

public class Q33_Search {
    // HashMap解法
    public int search(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        if(hm.containsKey(target)){
            return hm.get(target);
        }
        return -1;
    }
    //
    public int search_2(int[] nums, int target) {
        int res = -1;
        int k= nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                k=i;
                break;
            }
        }
        res = binarySearch(nums, 0,k,target);
        if(res==-1&&k<nums.length-1){
            res = binarySearch(nums,k+1,nums.length-1,target);
        }
        return res;
    }
    private  int binarySearch(int[] nums, int start, int end, int target){
        int ans = -1;
        while (start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                ans=mid;
                break;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q33_Search q33 = new Q33_Search();
        int[] a = {4,5,6,7,0,1,2};
        int res =q33.search_2(a,3);
    }

}
