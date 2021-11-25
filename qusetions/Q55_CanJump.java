package qusetions;

public class Q55_CanJump {
    // 逆向跳跃
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int now = n-1;
        boolean canjump = true;
        while(now>0){
            canjump = false;
            for(int pre=0; pre<now; pre++){
                if(pre+nums[pre]>=now){
                    now=pre;
                    canjump=true;
                    break;
                }
            }
            if(!canjump){
                break;
            }
        }
        return canjump;
    }
}
