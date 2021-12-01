package qusetions;

public class Q29_Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        // falg=1,符号相反；=0，符号相同；
        int flag = (dividend>>>31)^(divisor>>>31);
        // 被除数为-2**31
        dividend = beNegative(dividend);
        divisor = beNegative(divisor);
        int result = 0;
        while (dividend<=divisor){
            result--;
            dividend-=divisor;
        }
        if(flag==0){
            if(result!=0&&result==(~result+1)){
                result--;
            }
            else{
                result = ~result+1;
            }
        }
        return result;
    }

    public int beNegative(int a){
        if(a>>>31==0){
            return -a;
        }
        return a;
    }

    public static void main(String[] args) {
        Q29_Divide q29 = new Q29_Divide();
        System.out.println(Integer.toBinaryString(-2147483648));
        int b=q29.divide(-2147483648,4);
        System.out.println(b);
    }
}
