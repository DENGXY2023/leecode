package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q679_JudgePoint24 {
    static char[] operators = new char[]{'+','-','*','/'};
    static final int target = 24;
    static double epsilon = 1e-6;
    public boolean judgePoint24(int[] cards) {
        List<Double> numList = new ArrayList<>(){{
            for(int num : cards){
                add((double)num);
            }
        }};
        return solve(numList);

    }
    public boolean solve(List<Double> numList){
        if(numList.size()==0){
            return false;
        }
        if(numList.size()==1){
            return Math.abs(numList.get(0)-target)<epsilon;
        }
        for(int i=0;i<numList.size();i++){
            for(int j=0;j<numList.size();j++){
                if(i!=j){
                    List<Double> numList2 = new ArrayList<>();
                    for(int k=0;k<numList.size();k++){
                        if(k!=i&&k!=j){
                            numList2.add(numList.get(k));
                        }
                    }
                    for(char op : operators){
                        double value = valueOfTwoNums(numList.get(i),numList.get(j),op);
                        if(value==Float.POSITIVE_INFINITY){
                            continue;
                        }
                        else {
                            numList2.add(value);
                        }
                        if(solve(numList2)){
                            return true;
                        }
                        numList2.remove(numList2.size()-1);
                    }

                }

            }
        }
        return false;
    }
    public double valueOfTwoNums(double num1,double num2,char operator){
        double result =0;
        switch (operator){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                if(num2!=0){
                    result=num1/num2;
                }
                else {
                    result = Float.POSITIVE_INFINITY;
                }
                break;
        }
        return result;
    }

}
