package qusetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5965_GetDistance {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long [] ans = new long[n];
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(arr[i],list);
            }
            hm.get(arr[i]).add(i);
        }
        for(int i=0;i<n;i++){
            List<Integer> list = hm.get(arr[i]);
            for(int a:list){
                ans[i]+=Math.abs(a-i);
            }
        }
        return ans;
    }
}
