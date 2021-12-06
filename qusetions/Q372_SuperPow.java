package qusetions;

public class Q372_SuperPow {
    public int superPow(int a, int[] b) {
        a=a%1337;
        int n = b.length;
        int res =1;
        for(int i=0;i<n;i++){
            int ab = (int)Math.pow(a,b[i]);
            for(int j=n-i;j>0;j--){
                res = res*ab%1337;
                ab = (int)Math.pow(ab,10)%1337;
            }

        }
        return res;
    }
    static final int MOD = 17;

    public int superPow_2(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Q372_SuperPow q372 = new Q372_SuperPow();
        int a=2;
        int[] b ={1,0,3};
        System.out.println(q372.pow(3,6));
    }
}
