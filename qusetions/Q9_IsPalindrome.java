package qusetions;

public class Q9_IsPalindrome {
    public boolean isPalindrome(int x){
        Boolean flag = true;
        String xx = String.valueOf(x);
        int length = xx.length();
        for(int i=0;i<length/2;i++){
            if(xx.charAt(i)!=xx.charAt(length-i-1)){
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Q9_IsPalindrome q9 = new Q9_IsPalindrome();
        System.out.println(q9.isPalindrome(-121));
    }
}
