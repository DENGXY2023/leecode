package qusetions;
/*
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n)
 */
public class Q509_Fib {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int f1=0,f2=1;
        int fn = 0;
        for(int i =2;i<=n;i++){
            fn=f1+f2;
            f1=f2;
            f2=fn;
        }
        return fn;
    }
}
