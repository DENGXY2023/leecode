package qusetions;

import java.math.BigInteger;

public class Q43_Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m+n];
        for(int i=n-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            for(int j=m-1;j>=0;j--){
                int b = num2.charAt(j)-'0';
                int digit = a*b;
                res[i+j+1]+=digit%10;
                res[i+j]+=digit/10;
                if(res[i+j+1]>=10){
                    res[i+j]+=res[i+j+1]/10;
                    res[i+j+1] %= 10;
                }
                if(res[i+j]>=10){
                    res[i+j-1]+=res[i+j]/10;
                    res[i+j] %= 10;
                }
            }

        }
        int index = res[0]==0?1:0;
        StringBuilder ans = new StringBuilder();
        for(int i=index;i<=m+n;i++){
            ans.append(res[i]);
        }
        return ans.toString();
    }
    public StringBuilder addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n = num1.length();
        int m = num2.length();
        int add =0;
        while(n>0||m>0){
            int digit = add;
            if(n>0){
                digit += num1.charAt(n-1)-'0';
                n--;
            }
            if(m>0){
                digit += num2.charAt(m-1)-'0';
                m--;
            }
            add = digit/10;
            digit = digit%10;
            res.append(digit);
        }
        if(add>0){
            res.append(add);
        }
        return res.reverse();
    }

//    public String multiply_2(String num1, String num2){
//
//    }
    public static void main(String[] args) {
        Q43_Multiply q43 = new Q43_Multiply();
        String res = q43.multiply("123", "456");
    }
}
