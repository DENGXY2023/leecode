package qusetions;

public class Q45_Jump {
    // 贪心算法，正向
    public int jump(int[] nums) {
        int position = 0;
        int jumps = 0;
        while (position<nums.length-1){
            int nextPos=0, secondPos = 0, secondMaxPos = 0;
            if(position+nums[position]>=nums.length-1){
                jumps++;
                break;
            }
            for(int i =position+1;i<=position+nums[position];i++){
                secondPos = i+nums[i];
                if(secondPos>secondMaxPos){
                    nextPos = i;
                    secondMaxPos = secondPos;
                }
            }
            position = nextPos;
            jumps++;
        }
        return jumps;
    }
    //
    public int jump_2(int[] nums) {
        int position = nums.length-1;
        int jumps = 0;
        while (position>0){
            for(int i=0; i<position; i++){
                if(i+nums[i]>=position){
                    position=i;
                    jumps++;
                    break;
                }
            }
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
