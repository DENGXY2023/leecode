package qusetions;

public class Q704_Search {
    // 遍历搜索
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    // 二分查找
    public int search_2(int[] nums, int target) {
        int low =0, high =nums.length-1;
        while (low<=high){
            int mid =(high-low)/2+low;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high =mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return -1;
    }
}
