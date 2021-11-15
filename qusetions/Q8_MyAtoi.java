package qusetions;

public class Q8_MyAtoi {
    public int myAtoi(String s) {
        int r = 0;
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i)=='-'){
                flag = false;
            }
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0){
                int x = s.charAt(i)-'0';
                r =r*10+x;
            }
            if(s.charAt(i)-'0'<0 || s.charAt(i)-'9'>0){
                break;
            }
        }
        if(!flag){
            r=-1*r;
        }

        return r;
    }

    public static void main(String[] args) {
        Q8_MyAtoi q = new Q8_MyAtoi();

        String s = " 234a3";
        System.out.println(q.myAtoi(s));
    }

}
