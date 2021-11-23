package qusetions;

public class Q45_Jump {
    // 贪心算法，正向
    public int jump(int[] nums) {
        int start = 0, next =0;
        int startFast = 0, nextFast = 0;
        int jumps = 0;
        if(nums.length==1){
            return 0;
        }
        while(next<nums.length-1){
            startFast = start+nums[start];
            if(startFast>nums.length-1){
                jumps++;
                break;
            }
            int nextMostFast = 0;
            for(int i = start+1;i<=startFast;i++){
                nextFast = i+nums[i];
                if(nextFast>nextMostFast){
                    next = i;
                    nextMostFast = nextFast;
                }
            }
            start = next;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        Q45_Jump q45 = new Q45_Jump();
        int [] nums = {3,4,3,2,5,4,3};
        int a = q45.jump(nums);
        System.out.println(a);
    }
}
