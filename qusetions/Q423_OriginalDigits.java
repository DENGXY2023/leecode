package qusetions;

import java.util.HashMap;
import java.util.Map;

public class Q423_OriginalDigits {
    // a bug version
    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sMap =new HashMap<>();
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i =0; i<s.length(); i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i), 0)+1);
        }
        int j =0;
        while(j<10){
            boolean isExist = true;
            Map<Character, Integer> sMapNext = copy(sMap);
            for (char alphabet : digits[j].toCharArray()){
                if(!sMapNext.containsKey(alphabet)){
                    j++;
                    isExist = false;
                    break;
                }
                else if(sMapNext.get(alphabet)==1){
                    sMapNext.remove(alphabet);
                }
                else {
                    sMapNext.put(alphabet,sMapNext.get(alphabet)-1);
                }
            }
            if(isExist){
                sMap = sMapNext;
                sb.append(j);
            }
            if(sMap.isEmpty()){
                break;
            }
        }
        return sb.toString();
    }
    public static Map<Character, Integer> copy (Map<Character, Integer> origin){
        Map<Character, Integer> copy = new HashMap<>();
        for(Character cc:origin.keySet()){
            copy.put(cc,origin.get(cc));
        }
        return copy;
    }
    // 利用字母在单词中出现频率的统计规律
    public String originalDigits_2(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sMap =new HashMap<>();
        for(int i =0; i<s.length(); i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i), 0)+1);
        }
        int[] cnt = new int[10];
        cnt[0] = sMap.getOrDefault('z', 0);
        cnt[2] = sMap.getOrDefault('w', 0);
        cnt[4] = sMap.getOrDefault('u', 0);
        cnt[6] = sMap.getOrDefault('x', 0);
        cnt[8] = sMap.getOrDefault('g', 0);

        cnt[3] = sMap.getOrDefault('h', 0) - cnt[8];
        cnt[5] = sMap.getOrDefault('f', 0) - cnt[4];
        cnt[7] = sMap.getOrDefault('s', 0) - cnt[6];

        cnt[1] = sMap.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = sMap.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                sb.append((char) (i + '0'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q423_OriginalDigits  q423 = new Q423_OriginalDigits();
        String r = q423.originalDigits_2("fviefuro");
        System.out.println(r);
    }

}
