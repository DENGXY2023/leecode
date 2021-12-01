package qusetions;

public class Q223_ComputeArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1,s2,s3;
        s1=(ax2-ax1)*(ay2-ay1);
        s2=(bx2-bx1)*(by2-by1);
        if(bx1>=ax2||bx2<=ax1||by1>=ay2||by2<=ay1){
            s3=0;
        }
        else{
            int[] widths = new int[]{ax2 - bx1, bx2 - ax1, bx2 - bx1, ax2 - ax1};
            int[] heights = new int[]{ay2 - by1, by2 - ay1, by2 - by1, ay2 - ay1};
            s3 = getMin(widths)*getMin(heights);
        }
        return s1+s2-s3;
    }
    public int getMin(int[]nums){
        int minNum = nums[0];
        for(int i=0;i<nums.length;i++){
            minNum = Math.min(minNum,nums[i]);
        }
        return minNum;
    }
}
