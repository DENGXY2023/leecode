package qusetions;

import java.util.*;

public class Q20_IsValid {
    Map<Character, Integer> brackets = new HashMap<>();
    Q20_IsValid(){
        this.brackets.put('(',-1);
        this.brackets.put(')',1);
        this.brackets.put('{',-2);
        this.brackets.put('}',2);
        this.brackets.put('[',-3);
        this.brackets.put(']',3);
    }
    public boolean isValid(String s) {
        int len = s.length();
        boolean result = false;
        if(len==1){
            return false;
        }
        if(len==2){
            if(brackets.get(s.charAt(0))+brackets.get(s.charAt(1))==0){
                return true;
            }
            else return false;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<len;i++){
            int left = len-1;
            for(int j=i+1;j<left;j--){
                if(brackets.get(s.charAt(i))+brackets.get(s.charAt(j))==0){
                    left = j-1;
                    result = true;
                    break;
                }
                result = false;
            }
        }

        return result;
    }
    public boolean isValid_2(String s) {
//        Stack<Character> ss = new Stack<>();
        Deque<Character> ss = new ArrayDeque<>();
        for(int i=0; i<s.length();i++){
            if(ss.isEmpty()){
                ss.push(s.charAt(i));
                continue;
            }
            if(ss.peek()==')'||ss.peek()==']'||ss.peek()=='}'){
                break;
            }
            if(s.charAt(i)-ss.peek()==1||s.charAt(i)-ss.peek()==2){
                ss.pop();
                continue;
            }
            ss.push(s.charAt(i));
        }
        if(ss.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q20_IsValid q20 = new Q20_IsValid();
        boolean a = q20.isValid_2("(}{)");
        System.out.println(a);
    }


}
