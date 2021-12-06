package qusetions;

public class Q28_StrStr {
    // 暴力循环解法
    public int strStr(String haystack, String needle) {
        int n1= haystack.length();
        int n2 = needle.length();
        if(n2==0){
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        for(int i =0; i<=n1-n2;i++){
            Boolean isExist = true;
            for(int j =0;j<n2;j++){
                if(hay[i+j]!=need[j]){
                    isExist=false;
                    break;
                }
            }
            if(isExist){
                return i;
            }
        }
        return -1;
    }
    // KMP
    public int strStr_2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q28_StrStr q28 = new Q28_StrStr();
        String str1 = "cdaabaaab";
        String str2 = "aabaaab";
        int a = q28.strStr_2(str1, str2);
        System.out.println(a);
    }
}
