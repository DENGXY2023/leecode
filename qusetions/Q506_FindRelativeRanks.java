package qusetions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q506_FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n =score.length;
        String[] s = new String[n];
        int[] copy = Arrays.copyOf(score, n);
        Arrays.sort(copy);
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i=0;i<n;i++){
            hp.put(copy[i],n-i);
        }
        for(int i=0; i<n;i++){
            if(hp.get(score[i])==1){
                s[i] = "Gold Medal";
            }
            else if(hp.get(score[i])==2){
                s[i] = "Silver Medal";
            }
            else if(hp.get(score[i])==3){
                s[i] = "Bronze Medal";
            }
            else{
                s[i] = String.valueOf(hp.get(score[i]));
            }
        }
        return s;
    }
    public String[] findRelativeRanks_2(int[] score) {
        int n =score.length;
        String[] s = new String[n];
        String[] medal = {"Gold Medal","Silver Medal","Bronze Medal"};
        int[][] scoreWithNum = new int[n][2];
        for(int i=0; i<n;i++){
            scoreWithNum[i][0] = score[i];
            scoreWithNum[i][1] = i;
        }
        Arrays.sort(scoreWithNum,(a,b)->b[0]-a[0]);
        for(int i=0; i<n;i++){
            if(i<3){
                s[scoreWithNum[i][1]] = medal[i];
            }
            else{
                s[scoreWithNum[i][1]] = String.valueOf(i+1);
            }
        }
        return s;

    }
}
