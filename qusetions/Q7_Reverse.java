package qusetions;

public class Q7_Reverse{
    public int reverse(int x){
        int temp = 0;
        int nx = 0;
        while (x != 0){
            if (nx < Integer.MIN_VALUE/10  || nx > Integer.MAX_VALUE/10) {
                return 0;
            }
            temp = x%10;
            nx = nx*10+temp;
            x=x/10;
        }

        return nx;
    }

    public static void main(String[] args) {
        Q7_Reverse r = new Q7_Reverse();
        int a = r.reverse(953423646);
        System.out.println(a);
    }
}
