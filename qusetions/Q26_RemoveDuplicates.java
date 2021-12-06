package qusetions;

public class Q26_RemoveDuplicates {
    // 快慢指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j=0;
        for(int i=0; i<n;i++){
            if(i==n-1||nums[i]!=nums[i+1]){
                nums[j]=nums[i];
                j++;
            }

        }
        return j;
    }
}
