package qusetions;

public class Q31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int lastLess = n-1;
        Boolean flag =false;
        while(lastLess>0){
            if(nums[lastLess]>nums[lastLess-1]){
                flag = true;
                break;
            }
            lastLess--;
        }
        if(!flag){
            sort(nums, lastLess, n-1);
            return;
        }
        int i =n-1;
        for(;i>=lastLess;i--){
            if(nums[i]>nums[lastLess-1]){
                break;
            }
        }
        int temp = nums[i];
        nums[i] = nums[lastLess-1];
        nums[lastLess-1] = temp;
        sort(nums, lastLess, n-1);
    }
    public void sort(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
