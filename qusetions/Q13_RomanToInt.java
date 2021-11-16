package qusetions;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInt {
    public int romanToInt(String s) {
        int sum =0;
        for(int i =0;i<s.length();i++){

            switch (s.charAt(i)){
                case 'I':
                    if((i<s.length()-1)&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                        sum-=1;
                    }
                    else sum+=1;
                    break;
                case 'V':
                    sum+=5;
                    break;
                case 'X':
                    if((i<s.length()-1)&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                        sum-=10;
                    }
                    else sum+=10;
                    break;
                case 'L':
                    sum+=50;
                    break;
                case 'C':
                    if((i<s.length()-1)&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                        sum-=100;
                    }
                    else sum+=100;
                    break;
                case 'D':
                    sum+=500;
                    break;
                case 'M':
                    sum+=1000;
                    break;
            }

        }
        return sum;
    }
//    哈希表法
    public int romanToInt_2(String s) {
        int sum=0;
        Map<Character,Integer> valueOfRoman = new HashMap<>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};
        for(int i =0;i<s.length();i++){
            int value = valueOfRoman.get(s.charAt(i));
            if((i<s.length()-1)&&(value<valueOfRoman.get(s.charAt(i+1)))){
                value=-value;
            }
            sum+=value;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q13_RomanToInt q13 = new Q13_RomanToInt();
        int num = q13.romanToInt("LVIII");
        System.out.println(num);
    }
}
