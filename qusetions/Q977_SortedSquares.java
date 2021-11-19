package qusetions;

public class Q977_SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        int left = 0, right = nums.length-1;
        int i =newNums.length-1;
        while(left<=right){
            if(nums[left]*nums[left]>=nums[right]*nums[right]){
                newNums[i] = nums[left]*nums[left];
                left++;
            }
            else {
                newNums[i] = nums[right]*nums[right];
                right--;
            }
            i--;
        }
        return newNums;

    }
}
