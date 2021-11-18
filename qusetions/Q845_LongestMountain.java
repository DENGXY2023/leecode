package qusetions;

public class Q845_LongestMountain {
    public int longestMountain(int[] arr) {
        int lenOfLeft = 0, lenOfRight = 0,lenOfLong = 0;
        int init = 0;
        if(arr.length<3){
            return 0;
        }
        for(int i=1;i<arr.length-1;i++){

            for(int j=i-1;j>=init;j--){
                if(arr[j]>=arr[j+1]){
                    init = j;
                    break;
                }
                lenOfLeft ++;
            }
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>=arr[j-1]){
                    i = j-1;
                    break;
                }
                lenOfRight ++;
            }
            if(lenOfLeft>0&&lenOfRight>0){
                lenOfLong = lenOfLong>lenOfLeft + lenOfRight+1 ? lenOfLong:lenOfLeft + lenOfRight+1;
            }
            if(lenOfLong>arr.length/2){
                break;
            }
            lenOfLeft=lenOfRight=0;

        }
        return lenOfLong>=3 ? lenOfLong:0;
    }

    public static void main(String[] args) {
        Q845_LongestMountain q845 = new Q845_LongestMountain();
        int[] arr = {2,1,4,3,7,3,2,5};
        int len = q845.longestMountain(arr);
        System.out.println(len);
    }
}
