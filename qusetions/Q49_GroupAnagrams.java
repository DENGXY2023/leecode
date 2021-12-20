package qusetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49_GroupAnagrams {
    // 哈希表
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> hm = new HashMap<>();
        int n = strs.length;
        for(String str:strs){
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String ss = new String(cc);
            List<String> list = hm.getOrDefault(ss,new ArrayList<>());
            list.add(str);
            hm.put(ss,list);
        }
        for(List<String> ans: hm.values()){
            res.add(ans);
        }
        return res;
    }
    /*
    private String anagrams(String str){
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char cc:str.toCharArray()){
            arr[cc-'a']++;
        }
        for(int i=0;i<26;i++){
            while (arr[i]>0){
                sb.append('a'+i);
                arr[i]--;
            }
        }
        return sb.toString();
    }
     */
    public static void main(String[] args) {
        Q49_GroupAnagrams q49 = new Q49_GroupAnagrams();
        String[] strs = {"eata","teaa","tan","aate","nat","bat"};
        List<List<String>> res = q49.groupAnagrams(strs);
    }
}
