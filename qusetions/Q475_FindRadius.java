package qusetions;

public class Q475_FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        int minRadius =0;
        for(int i=0;i<houses.length;i++){
            int radius = minDistance(houses[i], heaters);
            minRadius = Math.max(minRadius,radius);
        }
        return minRadius;
    }
    private int minDistance(int house, int[] heaters){
        int left=0, right=heaters.length-1;
        int min=0;
        while (left<=right){
            int mid = (left+right)/2;
            if(heaters[mid]==house){
                return 0;
            }
            else if(heaters[mid]<house){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        right = right>=0?right:0;
        left = left<heaters.length?left:heaters.length-1;
        min = Math.min(Math.abs(house-heaters[left]),Math.abs(house-heaters[right]));
        return min;
    }

    public static void main(String[] args) {
        Q475_FindRadius q475 = new Q475_FindRadius();
        int[] heaters = {2,3};

        System.out.println(q475.minDistance(4,heaters));
    }
}
