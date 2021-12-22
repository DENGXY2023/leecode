package qusetions;

public class Q686_RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int n=a.length(), m=b.length();
        int index = repeatedStrStr(a,b);
        if(index==-1){
            return -1;
        }
        if(n-m-index>=0){
            return 1;
        }
        // (m-n+index)/n+1，向上取整
        return (m-n+index-1)/n+2;

    }
    private int repeatedStrStr(String haystack, String needle){
        int n=haystack.length(), m=needle.length();
        if(m==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            Boolean isEqual = true;
            for(int j=0;j<m;j++){
                if(haystack.charAt((i+j)%n)!=needle.charAt(j)){
                    isEqual=false;
                    break;
                }
            }
            if(isEqual){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q686_RepeatedStringMatch q686 = new Q686_RepeatedStringMatch();
        String a ="abc";
        String b = "cabca";
        System.out.println(q686.repeatedStringMatch(a,b));
    }
}
