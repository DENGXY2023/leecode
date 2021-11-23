package qusetions;

public class Q859_BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            int[] count = new int[26];
            for(int i =0;i<s.length()-1;i++){
                count[s.charAt(i)-'a']++;
                if(count[s.charAt(i)-'a']>1){
                    return true;
                }
            }
        }
        StringBuilder ss = new StringBuilder();
        StringBuilder sg = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                ss.append(s.charAt(i));
                sg.append(goal.charAt(i));
            }
        }
        if(ss.length()!=2){
            return false;
        }
        s = ss.toString();
        goal = sg.toString();
        if(s.charAt(0)==goal.charAt(1)&&s.charAt(1)==goal.charAt(0)){
            return true;
        }
        return false;

    }
}
