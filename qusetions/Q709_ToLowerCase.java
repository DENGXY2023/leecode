package qusetions;

public class Q709_ToLowerCase {
    public String toLowerCase(String s) {
        char[] ss = s.toCharArray();
        for(int i=0; i<ss.length;i++){
            if(ss[i]>='A'&&ss[i]<='Z'){
                ss[i] += 'a'-'A';
            }
        }
        return new String(ss);
    }

    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        a = (char) (a^32);
        b ^=32;
        System.out.println(a);
    }
}
