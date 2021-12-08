package qusetions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q32_LongestValidParentheses {
    // 栈
    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new LinkedList<>();
        int n = s.length();
        int max = 0;
        deque.offer(-1);
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                deque.offer(i);
            }
            if(s.charAt(i)==')'){
                deque.poll();
                if(deque.isEmpty()){
                    deque.offer(i);
                }
                else{
                    max=Math.max(max,i-deque.peek());
                }
            }
       }
        return max;
    }
    // 贪心算法，左右各循环一次；
    public int longestValidParentheses_2(String s) {
        int n = s.length();
        int max = 0;
        int left=0, right=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                left++;
            }
            else{
                right++;
            }
            if(right==left){
                max=Math.max(2*left,max);
            }
            if(right>left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='('){
                left++;
            }
            else{
                right++;
            }
            if(right==left){
                max=Math.max(2*right,max);
            }
            if(right<left){
                left=0;
                right=0;
            }
        }

        return max;
    }
}
