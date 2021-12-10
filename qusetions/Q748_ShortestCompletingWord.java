package qusetions;

import java.util.Arrays;

public class Q748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] l = new int[26];  // 统计小写字母出现次数
        String res="";
        int minLen = 15;
        for(char cc:licensePlate.toCharArray()){
            if(cc-'a'>=0&&cc-'a'<26){
                l[cc-'a']--;
            }
            if(cc-'A'>=0&&cc-'A'<26){
                l[cc-'A']--;
            }
        }
        for(String ss:words){
            Boolean flagOfWord = true;
            int[] ll = Arrays.copyOf(l,26);
            for(char sc:ss.toCharArray()){
                ll[sc-'a']++;
            }
            for(int i:ll){
                if(i<0){
                    flagOfWord=false;
                    break;
                }
            }
            if(flagOfWord){
                if(minLen>ss.length()){
                    minLen = ss.length();
                    res=ss;
                }
            }
        }
        return res;
    }
}
