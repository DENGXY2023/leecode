package qusetions;

public class Q12_IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num/1000>0){
            num=num-1000;
            sb.append("M");
        }
        while (num/100>0){
            if(num>=900){
                num=num-900;
                sb.append("CM");
            }
            else if(num>=500){
                num=num-500;
                sb.append("D");
            }
            else if(num>=400){
                num=num-400;
                sb.append("CD");
            }
            else{
                num = num-100;
                sb.append("C");
            }
        }
        while(num/10>0){
            if(num>=90){
                num=num-90;
                sb.append("XC");
            }
            else if(num>=50){
                num=num-50;
                sb.append("L");
            }
            else if(num>=40){
                num=num-40;
                sb.append("XL");
            }
            else{
                num = num-10;
                sb.append("X");
            }
        }
        while (num>0){
            if(num>=9){
                num=num-9;
                sb.append("IX");
            }
            else if(num>=5){
                num=num-5;
                sb.append("V");
            }
            else if(num>=4){
                num=num-4;
                sb.append("IV");
            }
            else{
                num = num-1;
                sb.append("I");
            }
        }
        return sb.toString();
    }
    public String intToRoman_2(int num) {
        StringBuilder sb = new StringBuilder();
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(romans[i]);
                num-=values[i];
            }
            if (num==0){
                break;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Q12_IntToRoman q12 =new Q12_IntToRoman();
        System.out.println(q12.intToRoman_2(1234));
    }
}
