package qusetions;

import java.util.HashMap;
import java.util.Map;

public class Q383_CanConstruct {
    // 哈希表
    public boolean canConstruct(String ransomNote, String magazine) {
        Boolean flag = true;
        Map<Character, Integer> r = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0; i<ransomNote.length();i++){
            r.put(ransomNote.charAt(i), r.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for (int i=0; i<magazine.length();i++){
            m.put(magazine.charAt(i), m.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(Character cc:r.keySet()){
            if(!m.containsKey(cc)||m.get(cc)!= r.get(cc)){
                flag = false;
            }
        }
        return flag;
    }
    public boolean canConstruct_2(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i=0; i<ransomNote.length();i++){
            r[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0; i<magazine.length();i++){
            m[magazine.charAt(i)-'a']++;
        }
        for(int j=0;j<26;j++){
            if(r[j]>m[j]){
                return false;
            }
        }
        return true;
    }
}
