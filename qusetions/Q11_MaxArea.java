package qusetions;

public class Q11_MaxArea {
    public int maxArea(int[] height) {
        int area = 0, maxArea = 0;
        int i = 0, j=height.length-1;
        while(i<j){
            area = (j-i)*Math.min(height[i], height[j]);
            maxArea = Math.max(area, maxArea);
            if(height[i]<=height[j]){
                i++;
            }
            else j--;
        }
        return maxArea;
    }

}
