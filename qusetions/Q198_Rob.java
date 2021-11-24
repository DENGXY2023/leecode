package qusetions;

public class Q198_Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int [n];
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            // 状态转移方程
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];

    }
}
