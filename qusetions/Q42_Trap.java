package qusetions;

import java.util.ArrayDeque;
import java.util.Deque;
// 接雨水
public class Q42_Trap {
    public int trap(int[] height) {
        int ans =0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&height[i]> height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int currWidth = i-left-1;
                int currHeight = Math.min(height[left],height[i])-height[top];
                ans +=currHeight*currWidth;
            }
            stack.push(i);
        }
        return ans;
    }
    public int trap_2(int[] height) {
        int n = height.length;
        int ans=0;
        int left=0, right=n-1;
        int leftMax=0, rightMax=0;
        while(left<right){
            if(height[left]>leftMax){
                leftMax = height[left];
            }
            if(height[right]>rightMax){
                rightMax = height[right];
            }
            if(height[left]<height[right]){
                ans+=leftMax-height[left];
                ++left;
            }
            else{
                ans+=rightMax-height[right];
                --right;
            }
        }
        return ans;
    }
}
