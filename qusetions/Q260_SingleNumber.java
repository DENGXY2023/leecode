package qusetions;

import java.util.Arrays;
import java.util.HashSet;

public class Q260_SingleNumber {
    public int[] singleNumber(int[] nums) {
        int[] a = new int[2];
        boolean isDouble = false;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i==j){
                    continue;
                }
                if(nums[i]==nums[j]){
                    isDouble = true;
                    break;
                }
            }
            if(!isDouble){
                if(a[0]==0&a[1]==0){
                    a[0]=nums[i];
                }
                else{
                    a[1]=nums[i];
                }

            }
            isDouble = false;
        }
        return a;
    }
    public int[] singleNumber_2(int[] nums) {
        int[] a = new int[2];
        HashSet<Integer> Num = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++){
            if(!Num.contains(nums[i])){
                Num.add(nums[i]);
            }
            else{
                Num.remove(nums[i]);
            }
        }
        int i =0;
        for (int value : Num){
           a[i] = value;
           i++;
        }

        return a;
    }

    public static void main(String[] args) {
        Q260_SingleNumber ans = new Q260_SingleNumber();
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(ans.singleNumber_2(nums)));
    }
}
