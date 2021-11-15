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

    public boolean isPalindrome_2(int x){
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int reverteNum = 0;
        while(x>reverteNum){
            reverteNum = reverteNum*10+x%10;
            x =x/10;
        }
        return x==reverteNum||x==reverteNum/10;
    }

    public static void main(String[] args) {
        Q9_IsPalindrome q9 = new Q9_IsPalindrome();
        System.out.println(q9.isPalindrome(121));
        System.out.println(q9.isPalindrome_2(121));
    }
}
