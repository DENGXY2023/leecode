package qusetions;

public class Q35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0, right =nums.length-1;
        if( target>nums[right]){
            return right+1;
        }
        while(left<right){
            int mid=(right-left)/2+left;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right = mid;
            }
            else{
                left =mid+1;
            }
        }
        return right;
    }
}
