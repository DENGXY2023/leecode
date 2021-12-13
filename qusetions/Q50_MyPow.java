package qusetions;

public class Q50_MyPow {
    public double myPow(double x, int n) {
//        long N = n;
//        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        double res =1;
        Boolean isNegative = false;
        if(n>>>31==1){
            isNegative = true;
            if(n==Integer.MIN_VALUE) {
                res *= x;
                n++;
            }
            n=-n;
        }
        res = pow(x,n);
        if(isNegative){
            res = 1/res;
        }
        return res;

    }
    public double pow(double x, int n){
        double res = 1.0;
        while(n>0){
            if(n%2==0){
//                res*=x*x;
                x=x*x;
                n/=2;
            }
            else{
                res*=x;
                n--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q50_MyPow q50 = new Q50_MyPow();
        System.out.println(q50.pow(2,10));
    }
}
