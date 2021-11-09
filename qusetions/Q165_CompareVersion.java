package qusetions;

public class Q165_CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i=0; i < (v1.length< v2.length?v1.length:v2.length); i++){
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }
            if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }
        }
        if(v1.length<v2.length){
            return -1;
        }
        else if(v1.length>v2.length){
            return 1;
        }
        else {
            return 0;
        }
    }
    public int compareVersion_2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i=0; i < (v1.length< v2.length?v2.length:v1.length); i++){
            int x =0, y=0;
            if(i< v1.length){
                x = Integer.parseInt(v1[i]);
            }
            if(i<v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if(x>y){
                return 1;
            }
            if(x<y){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.3";
        String version2 = "1.3.0";
        Q165_CompareVersion Q165 = new Q165_CompareVersion();

        System.out.println(Q165.compareVersion_2(version1,version2));
        char c= 40959;
        System.out.println(c);

    }
}
