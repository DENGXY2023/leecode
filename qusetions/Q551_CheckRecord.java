package qusetions;

public class Q551_CheckRecord {
    public boolean checkRecord(String s) {
        char[] chs;
        chs = s.toCharArray();
        int ANum = 0;
        int LCNum = 0;
        for (char ch : chs){
            if(ch == 'A'){
                ANum++;
            }
            if(ch == 'L'){
                LCNum++;
            }
            else{
                LCNum=0;
            }
            if(ANum>=2||LCNum>=3){
                return false;
            }
        }
        return true;
    }
    public boolean checkRecord_2(String s){
        int len = s.length();
        int ANum = 0, LCNum = 0;
        for (int i=0; i<len; i++){
            if(s.charAt(i)=='A'){
                ANum++;
            }
            if(s.charAt(i)== 'L'){
                LCNum++;
            }
            else{
                LCNum = 0;
            }
            if(ANum>=2||LCNum>=3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q551_CheckRecord cr = new Q551_CheckRecord();
        System.out.println(cr.checkRecord("PPALLLPP"));
        System.out.println(cr.checkRecord_2("PPALLLPP"));
    }
}
