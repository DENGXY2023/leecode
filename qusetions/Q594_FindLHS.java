package qusetions;

public class Q594_FindLHS {
    // bug version
    public int findLHS(int[] nums) {
        int  maxLen =0;
        for(int i=0;i<nums.length;i++){
            int len1 = 0, len2 =0,len =0;
            int min=nums[i],max=nums[i];
            int min1=nums[i],max1=nums[i]+1;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<min1||nums[j]>max1){
                    continue;
                }
                max = Math.max(nums[j],max);
                len1++;
            }
            int min2=nums[i]-1,max2=nums[i];
            for(int j=i;j<nums.length;j++){
                if(nums[j]<min2||nums[j]>max2){
                    continue;
                }
                min = Math.min(nums[j],min);
                len2++;
            }

            len1 = (max-max1==0)?len1 : 0;
            len2 = (min-min2==0)?len2 : 0;
            len =Math.max(len1,len2);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q594_FindLHS q594 = new Q594_FindLHS();
        int[] nums = {2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2};
        System.out.println(q594.findLHS(nums));
    }


}
