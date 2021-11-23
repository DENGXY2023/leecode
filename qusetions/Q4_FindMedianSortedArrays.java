package qusetions;

public class Q4_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] nums = new int[len1+len2];
        while (i<len1||j<len2){
            if(nums1[i]<nums2[j]&&i<len1||j>len2-1){
                nums[k] = nums1[i];
                i++;
            }
            else{
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(k%2==0){
            return nums[k/2];
        }
        else {
            return ((double)(nums[k/2]+nums[k/2+1]))/2;
        }
    }
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len%2==0){
            return (double)((findKthNum(nums1, nums2, len/2)+findKthNum(nums1, nums2, len/2+1)))/2;
        }
        else{
            return (double) findKthNum(nums1, nums2, len/2+1);
        }
    }
    public int findKthNum(int[] nums1, int[] nums2, int k){
        int index1 = 0, index2 = 0;
        while (true){
            if(index1== nums1.length){
                return nums2[index2+k-1];
            }
            if(index2 == nums2.length){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(index1+k/2-1,nums1.length-1);
            int newIndex2 = Math.min(index2+k/2-1,nums2.length-1);
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1<=pivot2){
                k -= (newIndex1-index1+1);
                index1 = newIndex1 +1;
            }
            else{
                k -= (newIndex2-index2+1);
                index2 = newIndex2 +1;
            }
        }
    }

    public static void main(String[] args) {
        Q4_FindMedianSortedArrays q4 = new Q4_FindMedianSortedArrays();
        int [] a = {1,2};
        int [] b = {3,4};
        double r = q4.findMedianSortedArrays_2(a,b);
        System.out.println(r);
    }
}
