package qusetions;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backTrack(results, n, 0, 0, new StringBuilder());
        return results;
    }
    public void backTrack(List<String> results, int n, int open, int close, StringBuilder curr){
        if(curr.length()==2*n){
            results.add(curr.toString());
        }
        if(open<n){
            curr.append('(');
            backTrack(results,n,open+1,close,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(')');
            backTrack(results,n,open,close+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static void main(String[] args) {
        Q22_GenerateParenthesis q22 = new Q22_GenerateParenthesis();
        for(int i=1;i<=15;i++){
            List<String> results = q22.generateParenthesis(i);
            System.out.println(results.size());
        }

    }
}
