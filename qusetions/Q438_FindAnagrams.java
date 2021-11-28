package qusetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int pLen = p.length();
        List<Integer> result = new ArrayList<>();
        if(n<pLen){
            return result;
        }
        Map<Character, Integer> pp = new HashMap<>();
        for(char cc:p.toCharArray()){
            pp.put(cc,pp.getOrDefault(cc,0)+1);
        }
        Map<Character, Integer> ss = new HashMap<>();
        for(int j=0; j<pLen; j++){
            ss.put(s.charAt(j),ss.getOrDefault(s.charAt(j),0)+1);
        }
        if(sameString(ss,pp)){
            result.add(0);
        }
        for(int i=1; i<=n-pLen; i++){
            if(ss.get(s.charAt(i-1))>1){
                ss.put(s.charAt(i-1),ss.get(s.charAt(i-1))-1);
            }
            else{
                ss.remove(s.charAt(i-1));
            }
            ss.put(s.charAt(i+pLen-1),ss.getOrDefault(s.charAt(i+pLen-1),0)+1);
            // ss.equals(pp) 哈希表内部集成的接口
            if(sameString(ss,pp)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean sameString(Map<Character, Integer> ss, Map<Character, Integer> pp){
        for(Character key1:ss.keySet()){
            if(!pp.containsKey(key1)){
                return false;
            }
            if(!ss.get(key1).equals(pp.get(key1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q438_FindAnagrams q438 = new Q438_FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = new ArrayList<>();
        result = q438.findAnagrams(s,p);
        System.out.println(result);
    }
}
