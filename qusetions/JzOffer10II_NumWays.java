package qusetions;

import java.util.HashMap;
import java.util.Map;

public class JzOffer10II_NumWays {
    // 记忆化递归法，复杂度O（N)
    Map<Integer,Integer> tempMap = new HashMap<>();
    public int numWays(int n) {
        if(n<=2){
            return n>0? n:1;
        }
        if(tempMap.containsKey(n)){
            return tempMap.get(n);
        }
        else {
            tempMap.put(n,(numWays(n-1)+numWays(n-2))%1000000007);
            return (tempMap.get(n));
        }
    }
    // 动态规划法
    public int numWays_2(int n) {
        int[] nums =new int[n+1];
        if(n<=2){
            return n>0? n:1;
        }
        int s1=1,s2=2;
        int num=0;
        for(int i=3;i<=n;i++){
            nums[i] = (s1+s2)%1000000007;
            s1 = s2;
            s2 = nums[i];
        }
        return nums[n];
    }
}

