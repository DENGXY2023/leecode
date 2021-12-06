package qusetions;

public class Q1816_TruncateSentence {
    public String truncateSentence(String s, int k) {
        StringBuilder ss = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                k--;
            }
            if(k<1){
                break;
            }
            ss.append(s.charAt(i));
        }
        return ss.toString();
    }
}
