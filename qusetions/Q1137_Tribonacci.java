package qusetions;

public class Q1137_Tribonacci {
    public int tribonacci(int n) {
        if(n<2){
            return n;
        }
        if(n==2){
            return 1;
        }
        int t0=0,t1=1,t2=1;
        int tn=0;
        for(int i =3;i<=n;i++){
            tn = t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=tn;
        }
        return tn;
    }

}
