package qusetions;

public class Q1176_DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int score=0;
        int T=0;
        for(int j=0;j<k;j++){
            T+=calories[j];
        }
        for(int i=0;i<calories.length-k+1;i++){
            if(i>0){
                T-=calories[i-1];
                T+=calories[i+k-1];
            }
            if(T<lower){
                score--;
            }
            if(T>upper){
                score++;
            }
        }
        return score;
    }
}
