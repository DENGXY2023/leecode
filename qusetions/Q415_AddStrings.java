package qusetions;

public class Q415_AddStrings {
    public String addStrings(String num1, String num2) {
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
        return res.reverse().toString();
    }
}
