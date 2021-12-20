package qusetions;

public class Q96_NumTrees {
    // 递归
    public int numTrees(int n) {
        if(n<2){
            return 1;
        }
        int res=0;
        for(int i=1;i<=n;i++){
            res+=numTrees(i-1)+numTrees(n-i);
        }
        return res;
    }
    // 动态规划
    public int numTrees_2(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
