package qusetions;

public class Q34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res[0] = i;
                for(int j=i;j<nums.length;j++){
                    if(nums[j]!=target){
                        break;
                    }
                    res[1]=j;
                }
                break;
            }
        }
        return res;
    }
    // 二分法
    public int[] searchRange_2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx &&  nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
