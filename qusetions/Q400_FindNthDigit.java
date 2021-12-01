package qusetions;

public class Q400_FindNthDigit {
    public int findNthDigit(int n) {
        if(n<=9){
            return n;
        }
        int num=1;
        while (getTotalDigitsOfNum(num)<=n){
            num++;
        }
        int diff = n-getTotalDigitsOfNum(num-1);
        if(diff==0){
            int digits = 0;
            num--;
            int copyNum = num;
            while (num>0){
                digits++;
                num=num/10;
            }
            return String.valueOf(copyNum).charAt(digits-1)-'0';
        }
        char s= String.valueOf(num).charAt(diff-1);
        return s-'0';
    }
    public int findNthDigit_2(int n) {
        int base=9, digits=1;
        while(n>base&&n>base*digits){
            n -= base*digits;
            base *= 10;
            digits ++;
        }
        if(n%digits==0){
            int nums = (int)Math.pow(10,digits-1)+n/digits-1;
            return String.valueOf(nums).charAt(digits-1)-'0';
        }
        else{
            int nums = (int)Math.pow(10,digits-1)+n/digits;
            int diff = n%digits;
            return String.valueOf(nums).charAt(diff-1)-'0';
        }

    }
    public int getTotalDigitsOfNum(int num){
        int digits = 0;
        int copyNum = num;
        while (num>0){
            digits++;
            num=num/10;
        }
        int base =9;
        int totalDigits=0;
        for(int i=1; i<=digits; i++){
             totalDigits+=base*i;
             base=base*10;
        }
        totalDigits=totalDigits+(copyNum-(int)Math.pow(10,digits)+1)*digits;
        return totalDigits;

    }

    public static void main(String[] args) {
        Q400_FindNthDigit q400 = new Q400_FindNthDigit();
//        int a = q400.getTotalDigitsOfNum(98);
        int b = q400.findNthDigit_2(1000000000);
        System.out.println(b);
    }
}
