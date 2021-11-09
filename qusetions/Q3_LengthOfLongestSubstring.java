package qusetions;
import java.util.HashMap;
import java.util.HashSet;

public class Q3_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> HS = new HashSet<>();
        int maxlength = 0;
        if (s.length() == 0){
            return 0;
        }
        for(int i=0; i<s.length(); ++i){
            for(int j=i; j<s.length(); ++j){
                if(HS.contains(s.charAt(j))){
                    break;
                }
                else{
                    HS.add(s.charAt(j));
                    if (HS.size()>maxlength){
                        maxlength = HS.size();
                    }
                }
            }
            HS = new HashSet<>();
        }
        return maxlength;
    }
    public static int lengthOfLongestSubstring_2(String s){
        HashSet<Character> HS = new HashSet<>();
        int maxlength = 0;
        if (s.length() == 0){
            return 0;
        }
        int k =0;
        for(int i=0; i<s.length(); ++i){
            for(int j=k; j<s.length(); ++j){
                if(HS.contains(s.charAt(j))){
                    HS.remove(s.charAt(i));
                    k=j;
                    break;
                }
                else{
                    HS.add(s.charAt(j));
                    if (HS.size()>maxlength){
                        maxlength = HS.size();
                    }
                }
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String s = "abcabde";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring_2(s));
    }
}
