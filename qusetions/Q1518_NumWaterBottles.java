package qusetions;

public class Q1518_NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numEmpty = 0;
        int num =0;
        while (true){
            num += numBottles;
            numEmpty = numEmpty+numBottles;
            numBottles = numEmpty / numExchange;
            numEmpty = numEmpty % numExchange;
            if(numBottles==0){
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Q1518_NumWaterBottles ans = new Q1518_NumWaterBottles();
        System.out.println(ans.numWaterBottles(5,5));
    }
}
