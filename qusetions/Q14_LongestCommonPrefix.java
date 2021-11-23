package qusetions;

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int strsLen = strs.length;
        int minLenOfStrs = strs[0].length();
        for(int i=0; i<strsLen; i++){
            int lenOfStr = strs[i].length();
            minLenOfStrs = Math.min(minLenOfStrs, lenOfStr);
        }
        for(int j=0; j<minLenOfStrs; j++){
            boolean isSameChar = true;
            for(int i=0; i<strsLen; i++){
                if(strs[i].charAt(j)!=strs[0].charAt(j)){
                    isSameChar = false;
                    break;
                }
            }
            if(!isSameChar){
                break;
            }
            sb.append(strs[0].charAt(j));
        }
        return sb.toString();
    }

}
