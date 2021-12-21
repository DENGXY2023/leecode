package qusetions;

public class Q1154_DayOfYear {
    public int dayOfYear(String date) {
        int nDay =0;
        int year=0, mon=0, day=0;
        char[] charDate = date.toCharArray();
        int[] normalYear = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] leapYear = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        // 确定年月日
        for(int i=0;i<charDate.length;i++){
            if(i<4){
                year =year*10+charDate[i]-'0';
            }
            if(i>4&&i<7){
                mon = mon*10+charDate[i]-'0';
            }
            if(i>7){
                day = day*10+charDate[i]-'0';
            }
        }
        if((year%100==0&&year%400==0)||(year%100!=0&&year%4==0)){
            for(int i=1;i<mon;i++){
                nDay+=leapYear[i];
            }
        }
        else{
            for(int i=1;i<mon;i++){
                nDay+=normalYear[i];
            }
        }
        nDay+=day;
        return nDay;

    }

    public static void main(String[] args) {
        Q1154_DayOfYear q1154 = new Q1154_DayOfYear();
        System.out.println(q1154.dayOfYear("2021-12-21"));
    }
}
